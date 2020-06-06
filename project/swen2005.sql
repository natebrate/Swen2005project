-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 03, 2020 at 06:15 PM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
-- SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `swen2005_finalproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `prod_id` int(10) UNSIGNED NOT NULL COMMENT 'This is Product ID',
  `name` varchar(100) NOT NULL COMMENT 'This is Product Name',
  `quantity` int(10) NOT NULL COMMENT 'This is Product Quantity',
  `price` double(8,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`prod_id`, `name`, `quantity`, `price`) VALUES
(1, 'Sekiro: Shadows  Die Twice', 28, 20.00),
(2, 'Zelda: Twilight Princess', 28, 9.99),
(3, 'Just Cause 4 Bundle', 0, 40.00),
(4, 'Zelda: Breath of the Wild', 50, 45.70),
(5, 'Muramasa: The Demon Blade', 4, 12.00),
(6, 'Okami HD', 9, 25.80),
(7, 'Super Mario Galaxy Bundle', 4, 60.00),
(8, 'Super Smash Brothers Ultimate', 44, 57.00),
(9, 'Persona 5: The Royal', 44, 55.00),
(10, 'Skullgirls 2nd Encore', 10, 32.00),
(11, 'Pokemon Sword and Shield Bundle', 3, 75.95),
(12, 'Feeding Frenzy', 3, 4.99),
(13, 'Pokemon Sword', 2, 39.99),
(14, 'Pokemon Shield', 4, 39.99);

-- --------------------------------------------------------

--
-- Table structure for table `sales_details`
--

CREATE TABLE `sales_details` (
  `invoice` int(10) NOT NULL COMMENT 'This is the invoice number',
  `P_ID` int(10) UNSIGNED NOT NULL COMMENT 'This is the product id',
  `quantity_sold` int(10) UNSIGNED NOT NULL COMMENT 'This is the number of the given product sold',
  `sub_total` decimal(8,2) UNSIGNED NOT NULL COMMENT 'This is the amount paid for an item given its quantity'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------
DELIMITER ;;

--
-- TRIGGER FOR UPDATING SALES SUMMARY WHEN NEW SALES DETAILS ARE ADDED
--

CREATE TRIGGER transaction BEFORE  INSERT ON sales_details FOR EACH ROW
BEGIN


    if exists (select invoice from sales_summary where invoice=new.invoice) THEN
        UPDATE sales_summary SET total_revenue=total_revenue+new.sub_total where invoice=new.invoice ;
        UPDATE sales_summary SET items_sold=items_sold+new.quantity_sold where invoice=new.invoice ;

    ELSE
        insert into sales_summary (invoice, items_sold, total_revenue, DOS) values (new.invoice,new.quantity_sold, new.sub_total,CURDATE());

    END IF;
END ;;


-- --------------------------------------------------------

--
-- TRIGGER FOR DELETING A RECORD FORM SALES SUMMARY AND UPDATING APPROPRIATE TABLES
--

CREATE TRIGGER remove AFTER DELETE on sales_details for EACH ROW
BEGIN

    UPDATE sales_summary set total_revenue=total_revenue-old.sub_total where invoice=old.invoice;
    UPDATE sales_summary set items_sold=items_sold-old.quantity_sold where invoice=old.invoice;
    UPDATE products set quantity=quantity+old.quantity_sold where prod_id=old.P_ID;
END;;

-- --------------------------------------------------------

--
-- PROCEDURE FOR SELLING AN ITEM AND UPDATING THE APPROPRIATE TABLES
--

CREATE PROCEDURE `sell`(IN invoice_num INT ,in product_id int, in quan int)
BEGIN
    DECLARE subtotal DOUBLE;
    SET subtotal=quan*(select price from products where prod_id=product_id);
    UPDATE products SET quantity=quantity-quan where prod_id=product_id ;
    insert into sales_details(invoice, P_ID, quantity_sold, sub_total) values (invoice_num, product_id, quan,  subtotal);
END;;


-- --------------------------------------------------------

--
-- PROCEDURE FOR UPDATING A RECORD IN SALES DETAILS
--

CREATE  PROCEDURE `deleteInvoice`(IN invoice_num INT)
BEGIN


    delete from sales_details where invoice=invoice_num;
    delete from sales_summary where invoice=invoice_num;


END;;

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `sales_summary`
--

CREATE TABLE `sales_summary` (
  `invoice` int(10) NOT NULL,
  `items_sold` int(10) NOT NULL,
  `total_revenue` decimal(8,2) NOT NULL,
  `DOS` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` int(10) NOT NULL,
  `user_name` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `user_password` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `first_name` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `last_name` char(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `admin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users`
--

insert into sales_summary (invoice, items_sold,total_revenue,DOS) values (75906,0,0,'2020-04-11');
insert into sales_summary (invoice, items_sold,total_revenue,DOS) values (75907,0,0,'2020-04-21');
insert into sales_summary (invoice, items_sold,total_revenue,DOS) values (75908,0,0,'2020-04-17');


call sell (75906,2,1);
call sell (75906,13,1);
call sell (75907,11,1);
call sell (75907,2,1);
call sell (75908,14,1);
call sell (75908,6,1);



INSERT INTO `users` (`user_id`, `user_name`, `user_password`, `first_name`, `last_name`, `admin`) VALUES
(1, 'smith1', 'pass', 'John', 'Smith', 1),
(1001, 'smith2', 'pass', 'Jane', 'Smith', 1),
(1002, 'jones1', 'pass', 'Susan', 'Jones', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`prod_id`);

--
-- Indexes for table `sales_details`
--
ALTER TABLE `sales_details`
  ADD PRIMARY KEY (`invoice`,`P_ID`),
  ADD KEY `P_ID` (`P_ID`);

--
-- Indexes for table `sales_summary`
--
ALTER TABLE `sales_summary`
  ADD PRIMARY KEY (`invoice`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `prod_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'This is Product ID', AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `sales_summary`
--
ALTER TABLE `sales_summary`
  MODIFY `invoice` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1003;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `sales_details`
--
ALTER TABLE `sales_details`
  ADD CONSTRAINT `sales_details_ibfk_1` FOREIGN KEY (`P_ID`) REFERENCES `products` (`prod_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sales_details_ibfk_2` FOREIGN KEY (`invoice`) REFERENCES `sales_summary` (`invoice`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
