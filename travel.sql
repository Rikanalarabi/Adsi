/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 10.1.10-MariaDB : Database - travel1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`travel1` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `travel1`;

/*Table structure for table `jadwal` */

DROP TABLE IF EXISTS `jadwal`;

CREATE TABLE `jadwal` (
  `No_Keberangkatan` char(10) NOT NULL,
  `No_Booking` char(10) NOT NULL,
  `Id_Karyawan` char(10) NOT NULL,
  `Id_Supir` char(10) NOT NULL,
  `Jam_Keberangkatan` time DEFAULT NULL,
  `Tanggal_Keberangkatan` date DEFAULT NULL,
  `No_Tempat_Duduk` enum('A2','A3','A4','A5','A6','A7') DEFAULT NULL,
  `Tujuan_Keberangkatan` enum('Padang - Lubuk Basung','Lubuk Basung - Padang') DEFAULT NULL,
  PRIMARY KEY (`No_Keberangkatan`),
  KEY `Id_Supir` (`Id_Supir`),
  KEY `Id_Karyawan` (`Id_Karyawan`),
  KEY `No_Booking` (`No_Booking`),
  CONSTRAINT `jadwal_ibfk_1` FOREIGN KEY (`Id_Supir`) REFERENCES `pengemudi` (`Id_Supir`),
  CONSTRAINT `jadwal_ibfk_2` FOREIGN KEY (`Id_Karyawan`) REFERENCES `karyawan` (`Id_Karawan`),
  CONSTRAINT `jadwal_ibfk_3` FOREIGN KEY (`No_Booking`) REFERENCES `pelangan` (`No_Booking`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `jadwal` */

insert  into `jadwal`(`No_Keberangkatan`,`No_Booking`,`Id_Karyawan`,`Id_Supir`,`Jam_Keberangkatan`,`Tanggal_Keberangkatan`,`No_Tempat_Duduk`,`Tujuan_Keberangkatan`) values ('NK001','N001','A001','S001','10:00:00','2018-01-20','A2','Lubuk Basung - Padang');

/*Table structure for table `karyawan` */

DROP TABLE IF EXISTS `karyawan`;

CREATE TABLE `karyawan` (
  `Id_Karawan` varchar(10) NOT NULL,
  `Nama` char(20) DEFAULT NULL,
  `Username` char(20) DEFAULT NULL,
  `Password` char(20) DEFAULT NULL,
  `Alamat` char(50) DEFAULT NULL,
  `No_Hp` char(12) DEFAULT NULL,
  `Bagian` enum('Admin','Kasir') DEFAULT NULL,
  PRIMARY KEY (`Id_Karawan`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `karyawan` */

insert  into `karyawan`(`Id_Karawan`,`Nama`,`Username`,`Password`,`Alamat`,`No_Hp`,`Bagian`) values ('A001','Rikan','Rikan','12345','chicaheum','085321766333','Admin'),('K001','Taofik','Taofik123','67890','Pasir Kaliki','085261439876','Kasir');

/*Table structure for table `kendaraan` */

DROP TABLE IF EXISTS `kendaraan`;

CREATE TABLE `kendaraan` (
  `Id_Kendaraan` varchar(10) NOT NULL,
  `Plat_Nomor` char(12) DEFAULT NULL,
  `Merek_Mobil` enum('Avanza','AVP') DEFAULT NULL,
  `Id_Supir` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`Id_Kendaraan`),
  KEY `Id_Supir` (`Id_Supir`),
  CONSTRAINT `kendaraan_ibfk_1` FOREIGN KEY (`Id_Supir`) REFERENCES `pengemudi` (`Id_Supir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `kendaraan` */

insert  into `kendaraan`(`Id_Kendaraan`,`Plat_Nomor`,`Merek_Mobil`,`Id_Supir`) values ('K001','D0495KY','Avanza','S001'),('K002','D5630HG','AVP','S003');

/*Table structure for table `pelangan` */

DROP TABLE IF EXISTS `pelangan`;

CREATE TABLE `pelangan` (
  `No_Booking` varchar(10) NOT NULL,
  `Nama` char(20) DEFAULT NULL,
  `No_HP` varchar(12) DEFAULT NULL,
  `Alamat` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`No_Booking`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pelangan` */

insert  into `pelangan`(`No_Booking`,`Nama`,`No_HP`,`Alamat`) values ('N001','Rizal','085163549012','Cisitu');

/*Table structure for table `pengemudi` */

DROP TABLE IF EXISTS `pengemudi`;

CREATE TABLE `pengemudi` (
  `Id_Supir` varchar(10) NOT NULL,
  `Nama` char(20) DEFAULT NULL,
  `No_Hp` char(15) DEFAULT NULL,
  `Alamat` char(50) DEFAULT NULL,
  PRIMARY KEY (`Id_Supir`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `pengemudi` */

insert  into `pengemudi`(`Id_Supir`,`Nama`,`No_Hp`,`Alamat`) values ('S001','Ahmad','085321756351','cisarua'),('S002','Rio','085438102934','Antapani'),('S003','Edwar','087351437465','cikutra'),('S004','Rizal','085241739482','katamso');

/*Table structure for table `transaksi` */

DROP TABLE IF EXISTS `transaksi`;

CREATE TABLE `transaksi` (
  `No_Pembayaran` char(10) NOT NULL,
  `No_Booking` char(10) NOT NULL,
  `Id_Karyawan` char(10) NOT NULL,
  `Tujuan_Keberangkatan` enum('Padang - Lubuk Basung','Lubuk Basung - Padang') DEFAULT NULL,
  `Harga_Tiket` char(12) DEFAULT NULL,
  PRIMARY KEY (`No_Pembayaran`),
  KEY `No_Booking` (`No_Booking`),
  KEY `Id_Karyawan` (`Id_Karyawan`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`No_Booking`) REFERENCES `pelangan` (`No_Booking`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `transaksi_ibfk_2` FOREIGN KEY (`Id_Karyawan`) REFERENCES `karyawan` (`Id_Karawan`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaksi` */

insert  into `transaksi`(`No_Pembayaran`,`No_Booking`,`Id_Karyawan`,`Tujuan_Keberangkatan`,`Harga_Tiket`) values ('N001','N001','A001','Lubuk Basung - Padang','50.000'),('N002','N001','A001','Padang - Lubuk Basung','50.000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
