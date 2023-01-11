-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th1 11, 2023 lúc 04:51 PM
-- Phiên bản máy phục vụ: 10.4.25-MariaDB
-- Phiên bản PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `salescar`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `catalog`
--

CREATE TABLE `catalog` (
  `id` int(11) NOT NULL,
  `name` varchar(128) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `create_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `modifed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Đang đổ dữ liệu cho bảng `catalog`
--

INSERT INTO `catalog` (`id`, `name`, `create_at`, `modifed_at`) VALUES
(1, 'honda', '2023-01-11 13:51:06', '2023-01-23 13:51:06'),
(2, 'mec', '2023-01-11 13:00:19', '2023-01-26 13:00:19'),
(3, 'bmw', '2023-01-02 13:00:38', '2023-01-19 13:00:38');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
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
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`id`, `order_no`, `customer_name`, `customer_phone`, `customer_address`, `customer_email`, `identity_code`, `product_id`, `quantity`, `total`, `note`, `status`, `payment`, `create_at`, `modifed_at`) VALUES
(3, '', '', '', '', '', '', 6, 2, 199990, '', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(4, '', '', '', '', '', '', 2, 1, 1212120, 'xe dep', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(5, '', '', '', '', '', '', 5, 1, 2323, 'giam gia di anh oi', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(6, '', '', '', '', '', '', 4, 1, 2323, 'dao quoc truong mua', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(8, '', '', '', '', '', '', 1, 1, 9990000, 'dep tuyet cu meo', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24'),
(9, '', '', '', '', '', '', 2, 1, 1212120, 'xin chao dao ca', 0, 0, '2023-01-11 15:44:24', '2023-01-11 15:44:24');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
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
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `catalog_id`, `name`, `price`, `quantity`, `content`, `discount`, `image`, `created_at`, `modifed_at`, `status`) VALUES
(1, 1, 'crv\r\n', 9990000, 0, 'adasd', 10, '', '2023-01-04 13:51:25', '2023-01-05 13:51:25', 0),
(2, 1, 'civic', 1212120, 0, '21', 12, '123', '2023-01-06 13:01:14', '2023-01-13 13:01:14', 0),
(3, 2, 'c200', 2323, 0, '12', 34, '21', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(4, 2, 'e300', 2323, 0, '12', 34, '21', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(5, 2, 'glc300', 2323, 0, '12', 34, '21', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0),
(6, 3, 'i8', 2323, 0, '12', 34, '21', '2023-01-13 13:01:48', '2023-01-03 13:01:48', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `transaction`
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
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
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `name`, `email`, `phone`, `address`, `role`, `status`, `password`, `created_at`, `modifed_at`) VALUES
(1, 'daoquoctruong', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14'),
(3, 'truong', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14'),
(4, 'dqt', 'dao quoc truong', 'quoctruong@gmail.com', '1234567890', 'dao quoc truong', 0, 0, '202cb962ac59075b964b07152d234b70', '2023-01-03 12:28:14', '2023-01-05 12:28:14');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `catalog`
--
ALTER TABLE `catalog`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `product_id` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_catalog_id` (`catalog_id`),
  ADD KEY `catalog_id` (`catalog_id`);
ALTER TABLE `product` ADD FULLTEXT KEY `name` (`name`);

--
-- Chỉ mục cho bảng `transaction`
--
ALTER TABLE `transaction`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `order_id` (`order_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `catalog`
--
ALTER TABLE `catalog`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `transaction`
--
ALTER TABLE `transaction`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `product_ibfk_1` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`);

--
-- Các ràng buộc cho bảng `transaction`
--
ALTER TABLE `transaction`
  ADD CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `transaction_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
