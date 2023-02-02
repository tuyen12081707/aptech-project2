-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 16, 2023 at 12:24 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `salescar`
--

-- --------------------------------------------------------

--
-- Table structure for table `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `catalog`
--

INSERT INTO `catalog` (`id`, `name`, `create_at`, `modifed_at`) VALUES
(1, 'sedan', '2023-01-11 13:51:06', '2023-01-23 13:51:06'),
(2, 'SUV', '2023-01-11 13:00:19', '2023-01-26 13:00:19'),
(3, 'sport', '2023-01-02 13:00:38', '2023-01-19 13:00:38'),
(4, 'truck', '2023-01-11 13:00:19', '2023-01-26 13:00:19'),
(5, 'hatchback', '2023-01-02 13:00:38', '2023-01-19 13:00:38');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(255) NOT NULL,
  `order_no` varchar(50) NOT NULL,
  `customer_name` varchar(255) NOT NULL,
  `customer_phone` char(50) NOT NULL,
  `customer_address` varchar(255) NOT NULL,
  `customer_email` varchar(255) NOT NULL,
  `identity_code` varchar(20) NOT NULL,
  `product_id` int(255) NOT NULL,
  `quantity` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `note` varchar(255) NOT NULL,
  `status` tinyint(4) NOT NULL DEFAULT 0,
  `payment` int(4) NOT NULL DEFAULT 0,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `order_no`, `customer_name`, `customer_phone`, `customer_address`, `customer_email`, `identity_code`, `product_id`, `quantity`, `total`, `note`, `status`, `payment`, `create_at`, `modifed_at`) VALUES
(3, '', '', '', '', '', '', 6, 2, 199990, '', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(4, '', '', '', '', '', '', 2, 1, 1212120, 'xe dep', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(5, '', '', '', '', '', '', 5, 1, 2323, 'giam gia di anh oi', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(6, '', '', '', '', '', '', 4, 1, 2323, 'dao quoc truong mua', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(8, '', '', '', '', '', '', 1, 1, 9990000, 'dep tuyet cu meo', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(9, '', '', '', '', '', '', 2, 1, 1212120, 'xin chao dao ca', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(10, 'MA_NO_44378658', 'Vũ Mạnh Tuyên', '0986614332', '123', 'protuyen2001', '1234567890', 2, 1, 1212120, '123123', 0, 0, '2023-01-16 06:15:59', '2023-01-16 06:15:59');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(255) NOT NULL,
  `catalog_id` int(11) NOT NULL,
  `name` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(4) NOT NULL,
  `content` text COLLATE utf8_unicode_ci NOT NULL,
  `discount` int(11) NOT NULL,
  `image` varchar(255) CHARACTER SET utf8 NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` tinyint(4) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `catalog_id`, `name`, `price`, `quantity`, `content`, `discount`, `image`, `created_at`, `modifed_at`, `status`) VALUES
(1, 2, 'CRV', 999000000, 2, 'Động cơ: 1.5L\r\nHộp số: CVT\r\nCông suất cực đại: 188 / 5.600 (Hp / Rpm)\r\nMô-men xoắn cực đại: 240 / 2.000 - 5.000 (Nm / Rpm)', 10, '/aptech/project2/image/products/crv.jpg', '2023-01-04 13:51:25', '2023-01-05 13:51:25', 0),
(2, 1, 'Civic', 729000000, 3, 'Động cơ: 1.8 i-VTEC\r\nHộp số: CVT\r\nCông suất cực đại: 139/6500 (Hp / Rpm)\r\nMô-men xoắn cực đại: 174/4300 (Nm / Rpm)', 12, '/aptech/project2/image/products/civic.jpg', '2023-01-06 13:01:14', '2023-01-13 13:01:14', 0),
(3, 1, 'C200', 1709000000, 1, 'Động cơ: I4\r\nHộp số: Tự động 9 cấp 9G-TRONIC\r\nCông suất cực đại: 204/5800-6100(Hp / Rpm)\r\nMô-men xoắn cực đại: 300/1800 – 4000(Nm / Rpm)', 34, '/aptech/project2/image/products/c200.jpg', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(4, 1, 'E300', 2000000000, 1, 'Động cơ: 2.0L Turbo\r\nHộp số: Tự động 9 cấp 9G-TRONIC\r\nCông suất cực đại: 258/6.100(Hp / Rpm)\r\nMô-men xoắn cực đại: 370/1.650-4.000(Nm / Rpm)', 34, '/aptech/project2/image/products/e300.jpg', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(5, 2, 'GLC300', 2000000000, 2, 'Động cơ: I4\r\nHộp số: Tự động 9 cấp 9G-TRONIC\r\nCông suất cực đại: 190 /6100 (Hp / Rpm)\r\nMô-men xoắn cực đại: 370 /1800 – 4000(Nm / Rpm)', 34, '/aptech/project2/image/products/glc300.jpg', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(6, 3, 'I8', 2000000000, 0, 'Động cơ: Turbo 1.5L I3\r\nHộp số: 6AT\r\nCông suất cực đại: 369Hp (tổng)\r\nMô-men xoắn cực đại: 570Nm (tổng)', 34, '/aptech/project2/image/products/i8.jpg', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 1),
(7, 1, 'Accent', 426000000, 4, 'Động cơ: I4 / 1.4L\r\nHộp số: 5AT\r\nCông suất cực đại: 100/6000 (Hp / Rpm)\r\nMô-men xoắn cực đại: 132/4000 (Nm / Rpm)', '10', '/aptech/project2/image/products/accent.jpg', current_timestamp(), current_timestamp(), 0), 
(8, 1, 'Camry', 1000000000, 2, 'Động cơ: 6AR-FSE, 2.0l\r\nHộp số: CVT\r\nCông suất cực đại: 170/6600 (Hp / Rpm)\r\nMô-men xoắn cực đại: 206/4400-4900 (Nm / Rpm)', '12', '/aptech/project2/image/products/camry.jpg', current_timestamp(), current_timestamp(), 0), 
(9, 1, 'Vios', 489000000, 4, 'Động cơ: 2NR-FE\r\nHộp số: MT\r\nCông suất cực đại: 106/6000 (Hp / Rpm)\r\nMô-men xoắn cực đại: 140/4200 (Nm / Rpm)', '30', '/aptech/project2/image/products/vios.jpg', current_timestamp(), current_timestamp(), 0), 
(10, 1, 'K3', 619000000, 2, 'Động cơ: Gamma 1.6 MPI\r\nHộp số: 6MT\r\nCông suất cực đại: 126/6300 (Hp / Rpm)\r\nMô-men xoắn cực đại: 155/4850 (Nm / Rpm)', '30', '/aptech/project2/image/products/k3.jpg', current_timestamp(), current_timestamp(), 0);

-- --------------------------------------------------------

--
-- Table structure for table `transaction`
--

CREATE TABLE `transaction` (
  `id` bigint(20) NOT NULL,
  `action` tinyint(4) NOT NULL DEFAULT 0,
  `user_id` int(11) NOT NULL DEFAULT 0,
  `order_id` int(255) NOT NULL,
  `message` varchar(255) CHARACTER SET utf8 NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Dumping data for table `transaction`
--

INSERT INTO `transaction` (`id`, `action`, `user_id`, `order_id`, `message`, `created_at`, `modifed_at`) VALUES
(1, 1, 1, 10, 'sale sản phẩm nhiều hơn', '2023-01-16 07:05:29', '2023-01-16 07:05:29'),
(2, 2, 4, 3, 'order đã hoàn thành thanh toán', '2023-01-16 07:06:20', '2023-01-16 07:06:20'),
(3, 0, 1, 10, '123123', '2023-01-16 11:14:46', '2023-01-16 11:14:46'),
(4, 0, 1, 10, '123123123', '2023-01-16 11:15:00', '2023-01-16 11:15:00'),
(6, 2, 3, 10, 'sale thật nhiều', '2023-01-16 11:23:52', '2023-01-16 11:23:52');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(255) NOT NULL,
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `address` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `role` int(11) NOT NULL DEFAULT 0,
  `status` int(11) NOT NULL DEFAULT 0,
  `password` char(40) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `email`, `phone`, `address`, `role`, `status`, `password`, `created_at`, `modifed_at`) VALUES
(1, 'daoquoctruong', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14'),
(3, 'truong', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14'),
(4, 'dqt', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_catalog_id` (`catalog_id`),
  ADD KEY `catalog_id` (`catalog_id`);
ALTER TABLE `product` ADD FULLTEXT KEY `name` (`name`);

--
-- Indexes for table `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Constraints for table `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`);

--
-- Constraints for table `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
