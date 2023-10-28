-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 28, 2023 at 01:36 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java_database`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int NOT NULL,
  `nama` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `nama`, `email`, `password`, `created_at`, `updated_at`) VALUES
(211011, 'fazri', 'fazri@example.com', '123', '2023-10-25 20:07:55', '2023-10-26 13:45:44'),
(211012, 'Ahmad', 'ahmad@example.com', 'password456', '2023-10-25 20:07:55', NULL),
(211013, 'Agus', 'agus@example.com', 'password789', '2023-10-25 20:07:55', NULL),
(211014, 'Indah', 'indah@example.com', 'password1234', '2023-10-25 20:07:55', NULL),
(211015, 'Nur', 'nur@example.com', 'password5678', '2023-10-25 20:07:55', NULL),
(211016, 'Siti', 'siti@example.com', 'password9012', '2023-10-25 20:07:55', NULL),
(211017, 'Dwi', 'dwi@example.com', 'password1357', '2023-10-25 20:07:55', NULL),
(211018, 'Budi', 'budi@example.com', 'password2468', '2023-10-25 20:07:55', NULL),
(211019, 'Wulan', 'wulan@example.com', 'password3579', '2023-10-25 20:07:55', NULL),
(211020, 'Ahmad', 'ahmad@example.com', '123', '2023-10-26 22:02:59', NULL),
(211021, 'Bayu', 'bayu@example.com', '123', '2023-10-26 22:02:59', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=211022;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
