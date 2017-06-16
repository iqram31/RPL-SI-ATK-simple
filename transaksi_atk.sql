-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 01, 2017 at 02:19 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `transaksi_atk`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `username` varchar(30) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`username`, `password`) VALUES
('admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `alat_tulis`
--

CREATE TABLE IF NOT EXISTS `alat_tulis` (
  `kode` varchar(6) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `stok` int(11) NOT NULL,
  `satuan` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `alat_tulis`
--

INSERT INTO `alat_tulis` (`kode`, `nama`, `stok`, `satuan`) VALUES
('ATK001', 'Ballpoint Standar F2 0,7 ', 40, 'Buah'),
('ATK002', 'Bollpoint Gel 1.2', 28, 'Buah'),
('ATK003', 'Box Arsip meja', 40, 'Buah'),
('ATK004', 'Box file dari Karton', 50, 'Buah'),
('ATK005', 'Box file dari Plastik Merk Bantex', 20, 'Buah');

-- --------------------------------------------------------

--
-- Table structure for table `pegawai`
--

CREATE TABLE IF NOT EXISTS `pegawai` (
  `id_pegawai` varchar(5) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `divisi` varchar(50) NOT NULL,
  `no_hp` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pegawai`
--

INSERT INTO `pegawai` (`id_pegawai`, `nama`, `divisi`, `no_hp`) VALUES
('70461', 'Eris Runandi', 'Operation & Employee Relation', '08912393828'),
('70462', 'Lukman Hakim', 'Operation & Employee Relation', '0812312345'),
('70470', 'Ade Firman', 'Employee Welfare', '12345678'),
('70472', 'Candra Irawan', 'Employee Welfare', '12345678');

-- --------------------------------------------------------

--
-- Table structure for table `trans_atk_keluar`
--

CREATE TABLE IF NOT EXISTS `trans_atk_keluar` (
  `kode_klr` varchar(15) NOT NULL,
  `kode_atk` varchar(6) NOT NULL,
  `tgl_klr` date NOT NULL,
  `jumlah` int(11) NOT NULL,
  `id_pegawai` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans_atk_keluar`
--

INSERT INTO `trans_atk_keluar` (`kode_klr`, `kode_atk`, `tgl_klr`, `jumlah`, `id_pegawai`) VALUES
('KLR/010617/0001', 'ATK001', '2017-06-01', 10, '70470'),
('KLR/010617/0002', 'ATK002', '2017-06-01', 2, '70462');

-- --------------------------------------------------------

--
-- Table structure for table `trans_atk_masuk`
--

CREATE TABLE IF NOT EXISTS `trans_atk_masuk` (
  `kode_msk` varchar(15) NOT NULL,
  `kode_atk` varchar(6) NOT NULL,
  `tgl_msk` date NOT NULL,
  `jumlah` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trans_atk_masuk`
--

INSERT INTO `trans_atk_masuk` (`kode_msk`, `kode_atk`, `tgl_msk`, `jumlah`) VALUES
('MSK/010617/0001', 'ATK001', '2017-06-01', 50),
('MSK/010617/0002', 'ATK002', '2017-06-01', 30),
('MSK/010617/0003', 'ATK003', '2017-06-01', 40),
('MSK/010617/0004', 'ATK004', '2017-06-01', 50),
('MSK/010617/0005', 'ATK005', '2017-06-01', 20);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
 ADD PRIMARY KEY (`username`);

--
-- Indexes for table `alat_tulis`
--
ALTER TABLE `alat_tulis`
 ADD PRIMARY KEY (`kode`);

--
-- Indexes for table `pegawai`
--
ALTER TABLE `pegawai`
 ADD PRIMARY KEY (`id_pegawai`);

--
-- Indexes for table `trans_atk_keluar`
--
ALTER TABLE `trans_atk_keluar`
 ADD PRIMARY KEY (`kode_klr`), ADD KEY `kode_atk` (`kode_atk`), ADD KEY `id_pegawai` (`id_pegawai`);

--
-- Indexes for table `trans_atk_masuk`
--
ALTER TABLE `trans_atk_masuk`
 ADD PRIMARY KEY (`kode_msk`), ADD KEY `kode_atk` (`kode_atk`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `trans_atk_keluar`
--
ALTER TABLE `trans_atk_keluar`
ADD CONSTRAINT `trans_atk_keluar_ibfk_1` FOREIGN KEY (`kode_atk`) REFERENCES `alat_tulis` (`kode`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `trans_atk_keluar_ibfk_2` FOREIGN KEY (`id_pegawai`) REFERENCES `pegawai` (`id_pegawai`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `trans_atk_masuk`
--
ALTER TABLE `trans_atk_masuk`
ADD CONSTRAINT `trans_atk_masuk_ibfk_1` FOREIGN KEY (`kode_atk`) REFERENCES `alat_tulis` (`kode`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
