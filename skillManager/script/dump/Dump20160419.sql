CREATE DATABASE  IF NOT EXISTS `skillmanager` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `skillmanager`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: 127.0.0.1    Database: skillmanager
-- ------------------------------------------------------
-- Server version	5.0.86-community-nt

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Not dumping tablespaces as no INFORMATION_SCHEMA.FILES table on this server
--

--
-- Table structure for table `picture`
--

DROP TABLE IF EXISTS `picture`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL auto_increment,
  `picture_name` varchar(45) default NULL,
  `picture_data` longblob,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture`
--

LOCK TABLES `picture` WRITE;
/*!40000 ALTER TABLE `picture` DISABLE KEYS */;
INSERT INTO `picture` VALUES (1,'1111',''),(2,'11234','����\0JFIF\0\0\0\0\0\0��\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342��\0C			\r\r2!!22222222222222222222222222222222222222222222222222��\0\0p\0�\"\0��\0\0\0\0\0\0\0\0\0\0\0	\n��\0�\0\0\0}\0!1AQa\"q2���#B��R��$3br�	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz���������������������������������������������������������������������������\0\0\0\0\0\0\0\0	\n��\0�\0\0w\0!1AQaq\"2�B����	#3R�br�\n$4�%�\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyz��������������������������������������������������������������������������\0\0\0?\0�ׯ5/Zb�S�g��#�I�8�)��B����@��������g��>�jw���2���G<�PN8#8�W��f�|��/M��̥-��WD�*�Q�:�֦S�wcT��W7�q�=rNk\Z�S��YE���	#3��d��)�[�J�3-�(�;b�Ir	(�R�K`\0�)��;�\nQ�d���$�ǐix�\n�<I,N��eu9 ��RlcڬMX����Rj�FGZd�5����˿���{�\r�.0G�`��\\ԭ4}>�񮭈�\0�M!��}�������=��W+�_]����n!���,yH���s`n}�s�p>l�ҹ+c�Q��ދ}�uS�Ԝ���S(CL`qQiZ���.���Ҙ�ԫC����g�PzW\\$�%�9�MŴ�&<��^����SD��%��kq�Eh�LQ@����*U*�zx�S���Y�#�S3l{qS[YIp�cC#�h8�i��c\0P.��1=��]�E\0d�{V5ە)E;]n�^�eӦ��z�?x��^.��z�����k,����\0+����9\'I5�|:𾩨h6sk�7K�&�O8Ut%�2e��$)8=NA��5���V���\r��eN:8�:�T�l�v��m��^\n�\'�����b�o[��i�zU��/i	Y���W����\Z�m�������������k~\Z��:��.>ɩ�2=��{����\\�Cq�שa��<Qc`�=�1ߒ�do������ھ�[L���Ǫ;�B,W�� @���\"�9\'�d�nzϖ<�f���I�>|@��[+���bO.0DrǞ��H# O��!{�\r|�����~�y%��^7#���OC_\\i��aku\\F�9۞���E\Z���JQR�J���:\\��B$��J?�?��i�m�^�+[{O&G�&2��F*�$��c,OA���\Z$J�F}+�?�6ͦ�B�lbf6�M�����̜��/���W�FU\'���+��]��gDҧG�Z�:�:�j�3�|� �k_9�p	���\0���P zW�|����Y.l��ެ\n�=�Toʽ�[f��N��p�Sj���!z�[l*����Y�����{�9��2+.�;��YB�����1c���Ɨ4�E����_A�^]b��W~Ԃ���m�^=�x����f�4�A �.y��z��zƴ/b�+;�ש9�l�s�3��O�֩����[��8����G$�����X�#h���1�m�\\��FNښ�NM�����I��9bo�$lOЊ��1����<-��~k���oؑ%um������;l\r��k������0զ���sX+��teq����=+�2����jz3\\�)w�P2I=+��Ɠl���(�rX0UpI��~�z��Rk�ׯ*$zu��!~c���8��ڼ���������Ñ�`S��R�D;������jR\\\0����x�1����\n�?�λk7��c���(���U���8��׮>c�O6�8�$�2y���J�g�-�����Q\Z�E�9�d�\n_�\\UrsG�˟�j\'к���`�6A\r|��5��{�\0\r=N{���\0��^�ǝl�29�)���N�Z�wD�Ȕ�\'nNT���#>�u���(T�E�ޤ�����<)r�w�-��t�inC���l\'8��}8F�q_��x�W�GI\"m��pT���z�W�6:�\Z��g4q�ۤ���:�\0�5ҥy;��&8���PIL�sO[�+=9�	C���e	��O�E_�n�*(�X�#jg�4r&~B+��(�\n��Q��x��k�\\�\r��2�:%ޠ�\Zh���H�U�?,jq��G^��x%s�x����3o�4�k>L|��b=��Z�[�u>��ZW��f�*��cBI�ʳF�~\\g�\Z�!���R�aR��.2Ķ��)9=q�Ry�)�4.V>Y\0�8��Y�ǌ4�	�/ux��l��~iXv���� �N���@�^���\0��k8�f��$���\0e�rzg�U�i ��O�x�Qקy��&i��#�0��Gs\\�z�UÏ�z\"\\&��Jf��)X�gL���3ֽ��}3�Э��-֮���9��AX�`0Fq���MX�k�Ҳu-���������>��M�k���>{�!���@��� �$ma���W>t�!a�9@p�x�ߏZ�>$��q�-Yd�\'�q$���@�6��\'�LםL��%��	%����W{\"b�/Bm9�%b�����<~���W��W\'����qUP�;A���������V�	��bR�>Ӊc����Ъd{�i�r�9E6�ͯ�F�͍l5_2Kpp����w�v^��a�un���ԐJ�G\'�����Ԃq^7�isi�� ��)<���0���28��N�Y��E])ܽ���wBA��9��x�N�VkCs�+�����?�>[�\r����z1-�d~�\Z�ɸ\\6:�5�_�����X��##���xڅHG��\r��Xs8jmk��ֲ���E]��Pa�[RB?�USf�ۉ�����m�*�[`u����c�#ܙ�S��V0�:\Z��x4�&�j���⍠�)Z^���*���\n��E�:�������j3C���j�8<���nq�ӌ��j����x�wwi�0(-���и\0v��s��Y̚U��ys<�]O\Z��(����E	.��8f&�d���OM��rk0������Ű��8��\0^ƬjS�\\�F�Rw\0O�T ���\0P���W�f}�\Z��$u�9砭\'ٙ�z���a,�nf 1@��_ַ�j��bt�.���{ƿ3g9c����O��[;��@�g��0	��4>I�v�&��+��U�Glaq�\\~c<�\"�$0<��޺]Mdq,��E��%�L�z���B��\01䓒2kilcH��4�jֶ�`��yS��9c�e��+�hz���-�KD���X�#����t�Cd�0A�����	l��H2	��n��F?�}weo�e�@m��1�u?�Z*i��y�y���iv6�]��æ����(��%Y�s�?�:q^\r�YK���c#FU�0<��>�ھ���Ɔ�Bn��̑�XwQ����^	�hi��$1[�Ih�����C��}�869ny�]ĮNI���vu���:��#)��m�iU��.ҹ������YM���B�T8��T�]��u��ջ;X��4��˘�1\0�\\u�j�\'�X�w�C�Q����+�Ʒ_T�zQU�+�~/��\\����.��L�\0�\\��8���bz�.���7\"�i���V�&��v�$�8U@=+S���ʉ�\'|�3�����ďn�?j�����%���yhϵI��\0��;_�OҬ�h�Mѩ��`9��c�)���Ge��JK��D�}r?*��+�^��\0^0J�	�F*��gY�Y�tiI�v�����J�*k`���759Z�3����a�\0	E���Q^���]7Q.��[+��<|�1��Ɂ��T\Z��h��2wX�1����֮�C��j0��̒c���wt�����w��$�z�u�[[}Kc;4�g����y�r;t\0��Ǥgq̉����?���䝑�\'k��>Z�\n.��\\�6F㝈��;���+��ķ�&HC�Ҽ��,4%��m��]�|�λL��}�V��.��Z6t)⫴f%#l��7Ěrkrjvȱ\\�d�5�d#�G��$��֦{��9�m�����4�n.� �6Q���M`�[I�ym߇�\Z��:�a3���6��s���~9��g���$12�滿/�eҨ�ť�&/�^xx�y�ן^C)��yr;��\'q�ܒN:�$�\rn�p��SU5>��/�.��J�Dqn�7�ǔ�B�[m�[�8�A�\0z���į��bm�(�F-�\nJ�������u��}���k�f�T|mr�z��\\���Ms�W�M;z�3�X���r�B��q��9�FE=݃ʑ\"�����B�rF=�?����YY\n���9��$�yu�_�+���5;%n���1>pcwv;��+����K���#z?|��3���c�+�\0Y]y��\n��q������A��9�:S涀�/�\Z��j�L�8��%Ё��	G�{�Z�[�mN�.�t�)p+���z�ڸ�_\0�b%7.�I���l���I�#B)�^�b���V��0�)��	�� ���MI=.G��\\�k�Y�s<���r�����k\Zt�\Z��[�tX��kߎ}	����:$��[]��7��|�0��I�=6�OB1�V�	��V�?��d�c\Z�h���� c8�u�}���X���� h���o/sy?�R�o8!������\'��6�ۥȹrAy��I8�<��{rt-|	ycs�L�\0UiFI嫶Ywg�9������=CPdy�n�.\ZVN9���zx5~��*��߃.d������VY�*I ��q[1]J�#>���Ha�x�\0r}�5��x\Zk(&�/�[� <0�73\09<I��k\\�B�m^�u����\0��R9��w�:砬�Rw����\Z�:��K��RD����7����9�E&�e�0�n��2��p�<�d���sr���Jx�E��Ge�q�,8�<���N��LX��g���W�P�_h\'7cj���e�^�b�����kX���&���\"VتX.�b�l�\'��A�@+#ó	�Gw8�uB�Ĉ�r���p��s�ԍ5�wh.�R^��)LG*���|��s��qƄ>	э���d�<�)\"7N����Ӝ���^�p�iWMq��+~�E�m8�~Rv�{��]F������@%�Kr�m+���\0��u\0u����%ċ���?�҆�۱��S�O�}FM=<9�8-���]X	���o�H\'<s�>�(3�Eg�ld�N��9ےs��$���`U��I-�2�G�I�ڻ������^;���i;j�3��');
/*!40000 ALTER TABLE `picture` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `history_mgt`
--

DROP TABLE IF EXISTS `history_mgt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history_mgt` (
  `idhistory_MGT` int(11) NOT NULL auto_increment,
  `personality_type` varchar(45) default NULL,
  `smil` varchar(45) default NULL,
  `maturity_employee` varchar(45) default NULL,
  `management_style` varchar(45) default NULL,
  `management_apply` varchar(45) default NULL,
  PRIMARY KEY  (`idhistory_MGT`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history_mgt`
--

LOCK TABLES `history_mgt` WRITE;
/*!40000 ALTER TABLE `history_mgt` DISABLE KEYS */;
INSERT INTO `history_mgt` VALUES (1,NULL,'Manger','1',NULL,NULL),(2,NULL,'chef de projet','2',NULL,NULL);
/*!40000 ALTER TABLE `history_mgt` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remuneration`
--

DROP TABLE IF EXISTS `remuneration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remuneration` (
  `idREMUNERATION` int(11) NOT NULL auto_increment,
  `brut` varchar(7) default NULL,
  `fixe` decimal(9,2) default NULL,
  `variable` decimal(9,2) default NULL,
  `commentaire` varchar(50) default NULL,
  `persons_id` int(11) default NULL,
  PRIMARY KEY  (`idREMUNERATION`),
  KEY `persons_id` (`persons_id`),
  CONSTRAINT `persons_id` FOREIGN KEY (`persons_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remuneration`
--

LOCK TABLES `remuneration` WRITE;
/*!40000 ALTER TABLE `remuneration` DISABLE KEYS */;
INSERT INTO `remuneration` VALUES (1,'N','20000.00','0.00','OK',NULL),(2,'N-1','20000.00','10000.00','OK',NULL),(3,'N-2','0.00','0.00','KO',NULL),(4,'N-1','0.00','11111.00','OK',NULL),(5,'N-2','333.00','4444.00','KO',NULL),(6,'N','555.00','666.00','AAA:!!!',NULL),(7,'N-1','9999.00','77777.00','AZXDDA?',NULL);
/*!40000 ALTER TABLE `remuneration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `misc`
--

DROP TABLE IF EXISTS `misc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `misc` (
  `idactivity_prestation` int(11) NOT NULL auto_increment,
  `misc_description` varchar(255) default NULL,
  PRIMARY KEY  (`idactivity_prestation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `misc`
--

LOCK TABLES `misc` WRITE;
/*!40000 ALTER TABLE `misc` DISABLE KEYS */;
INSERT INTO `misc` VALUES (1,'description 1!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!::::::::;;;;;;;;;;,,,,,,,,,,,,,,aaaaaaaaaaaaaaaadsfdsd'),(2,'descption 2 du misc');
/*!40000 ALTER TABLE `misc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mission`
--

DROP TABLE IF EXISTS `mission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mission` (
  `idmission` int(11) NOT NULL auto_increment,
  `client` varchar(45) default NULL,
  `entitedMission` varchar(50) default NULL,
  `activite` varchar(45) default NULL,
  `dateDemarrage` date default NULL,
  `commentaire` varchar(255) default NULL,
  PRIMARY KEY  (`idmission`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mission`
--

LOCK TABLES `mission` WRITE;
/*!40000 ALTER TABLE `mission` DISABLE KEYS */;
INSERT INTO `mission` VALUES (1,'SII','stage','skillManager','2016-03-14','Fiche collaborateurs'),(2,'Leroy Merlin','stage_chez_client','Application','2016-04-18','Angular');
/*!40000 ALTER TABLE `mission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_cptsmetier`
--

DROP TABLE IF EXISTS `cv_cptsmetier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_cptsmetier` (
  `id` int(11) NOT NULL auto_increment,
  `job` varchar(255) default NULL,
  `specificities` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_cptsmetier`
--

LOCK TABLES `cv_cptsmetier` WRITE;
/*!40000 ALTER TABLE `cv_cptsmetier` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_cptsmetier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `behaviour`
--

DROP TABLE IF EXISTS `behaviour`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `behaviour` (
  `idbehavioral_competence` int(11) NOT NULL auto_increment,
  `strong_points` varchar(255) default NULL,
  `areas_improvement` varchar(255) default NULL,
  PRIMARY KEY  (`idbehavioral_competence`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `behaviour`
--

LOCK TABLES `behaviour` WRITE;
/*!40000 ALTER TABLE `behaviour` DISABLE KEYS */;
INSERT INTO `behaviour` VALUES (1,'Technique','Communication'),(2,'Communition','Technique');
/*!40000 ALTER TABLE `behaviour` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bu`
--

DROP TABLE IF EXISTS `bu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bu` (
  `id` int(11) NOT NULL auto_increment,
  `label` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bu`
--

LOCK TABLES `bu` WRITE;
/*!40000 ALTER TABLE `bu` DISABLE KEYS */;
INSERT INTO `bu` VALUES (1,'JAVA'),(2,'MICROSOFT'),(3,'BI'),(4,'MOBILITE'),(5,'RH');
/*!40000 ALTER TABLE `bu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `formation`
--

DROP TABLE IF EXISTS `formation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `formation` (
  `idformation` int(11) NOT NULL auto_increment,
  `entitled` varchar(45) default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`idformation`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `formation`
--

LOCK TABLES `formation` WRITE;
/*!40000 ALTER TABLE `formation` DISABLE KEYS */;
INSERT INTO `formation` VALUES (1,'Java','2016-01-01'),(2,'Android','2016-04-03');
/*!40000 ALTER TABLE `formation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `file`
--

DROP TABLE IF EXISTS `file`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `file` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(30) default NULL,
  `type` varchar(30) default NULL,
  `size` int(11) default NULL,
  `content` mediumblob NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `file`
--

LOCK TABLES `file` WRITE;
/*!40000 ALTER TABLE `file` DISABLE KEYS */;
/*!40000 ALTER TABLE `file` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remarks`
--

DROP TABLE IF EXISTS `remarks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remarks` (
  `idremarks` int(11) NOT NULL auto_increment,
  `remarks` varchar(255) default NULL,
  PRIMARY KEY  (`idremarks`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remarks`
--

LOCK TABLES `remarks` WRITE;
/*!40000 ALTER TABLE `remarks` DISABLE KEYS */;
INSERT INTO `remarks` VALUES (1,'remarks1'),(2,'Remarks2'),(3,'Remarks3');
/*!40000 ALTER TABLE `remarks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `skill`
--

DROP TABLE IF EXISTS `skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `skill` (
  `id` int(11) NOT NULL auto_increment,
  `person_id` int(11) NOT NULL,
  `level` int(11) default NULL,
  `item_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `person_id_idx` (`person_id`),
  KEY `item_id_idx` (`item_id`),
  CONSTRAINT `item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `person_id` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `skill`
--

LOCK TABLES `skill` WRITE;
/*!40000 ALTER TABLE `skill` DISABLE KEYS */;
INSERT INTO `skill` VALUES (1,1,5,1),(2,1,5,2),(4,1,4,3),(5,4,5,2),(6,4,4,1),(7,1,4,10),(8,1,5,7),(9,1,4,9),(10,1,4,8),(11,1,4,6),(12,1,0,4),(13,11,3,10),(14,11,5,2),(15,9,4,2),(16,9,4,7),(17,9,4,9),(18,9,4,8),(19,9,4,6),(20,9,4,1),(21,9,1,10),(22,14,3,10),(23,14,2,2),(24,14,2,8),(25,14,3,6),(26,14,4,3),(27,14,3,4),(28,9,4,3),(29,9,5,11);
/*!40000 ALTER TABLE `skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(45) default NULL,
  `trs_label_key` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (11,'JAVA','categroy.java'),(12,'new','new');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_cptstech`
--

DROP TABLE IF EXISTS `cv_cptstech`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_cptstech` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(255) default NULL,
  `technologies` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_cptstech`
--

LOCK TABLES `cv_cptstech` WRITE;
/*!40000 ALTER TABLE `cv_cptstech` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_cptstech` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(45) default NULL,
  `trs_label_key` varchar(45) default NULL,
  `category_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'SPRING','item.fwk.spring',11),(2,'JAVA','item.java',12),(3,'PHP','item.php',NULL),(4,'SYMFONY2','item.fwk.symfony',12),(6,'MySQL','MySQL',NULL),(7,'BIRT','Birt',12),(8,'MAVEN','Maven',11),(9,'HIBERNATE','Hibernate',11),(10,'ANDROID','Android',11),(11,'test','test',NULL),(12,'test','TEST',NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `career`
--

DROP TABLE IF EXISTS `career`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `career` (
  `idcareer` int(11) NOT NULL auto_increment,
  `poste` varchar(45) default NULL,
  `coefficient` varchar(45) default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`idcareer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `career`
--

LOCK TABLES `career` WRITE;
/*!40000 ALTER TABLE `career` DISABLE KEYS */;
INSERT INTO `career` VALUES (1,'developpeur','01','2016-01-01'),(2,'Manager','02','2016-02-02'),(3,'Chef de projet','03','2016-03-03');
/*!40000 ALTER TABLE `career` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_personfields`
--

DROP TABLE IF EXISTS `cv_personfields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_personfields` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `age` tinyint(4) default NULL,
  `function` varchar(255) default NULL,
  `yearsexp` tinyint(4) default NULL,
  `datedispo` datetime default NULL,
  `lastschool` varchar(255) default NULL,
  `id_expsign` int(11) default NULL,
  `id_cptstech` int(11) default NULL,
  `id_cptsmetier` int(11) default NULL,
  `id_school` int(11) default NULL,
  `id_exppro` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `personcv_id_idx` (`id_expsign`),
  KEY `cptstech_id_idx` (`id_cptstech`),
  KEY `cptsmetier_id_idx` (`id_cptsmetier`),
  KEY `school_id_idx` (`id_school`),
  KEY `exppro_id_idx` (`id_exppro`),
  CONSTRAINT `cptsmetier_id` FOREIGN KEY (`id_cptsmetier`) REFERENCES `cv_cptsmetier` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `cptstech_id` FOREIGN KEY (`id_cptstech`) REFERENCES `cv_cptstech` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `exppro_id` FOREIGN KEY (`id_exppro`) REFERENCES `cv_exppro` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `expsign_id` FOREIGN KEY (`id_expsign`) REFERENCES `cv_expsign` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `school_id` FOREIGN KEY (`id_school`) REFERENCES `cv_school` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_personfields`
--

LOCK TABLES `cv_personfields` WRITE;
/*!40000 ALTER TABLE `cv_personfields` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_personfields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_exppro`
--

DROP TABLE IF EXISTS `cv_exppro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_exppro` (
  `id` int(11) NOT NULL auto_increment,
  `client` varchar(255) default NULL,
  `activityclient` varchar(255) default NULL,
  `place` varchar(255) default NULL,
  `fonction` varchar(255) default NULL,
  `datebegin` datetime default NULL,
  `dateend` datetime default NULL,
  `summarymission` text,
  `detailsmission` varchar(255) default NULL,
  `activitymission` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_exppro`
--

LOCK TABLES `cv_exppro` WRITE;
/*!40000 ALTER TABLE `cv_exppro` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_exppro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `person` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(45) default NULL,
  `lastname` varchar(45) default NULL,
  `matricule` varchar(45) default NULL,
  `id_bu` int(11) default NULL,
  `admin` tinyint(1) default NULL,
  `login` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  `id_picture` int(11) default NULL,
  `manager` tinyint(1) default NULL,
  `birth_date` date default NULL,
  `Tel` varchar(15) default NULL,
  `hobby` varchar(255) default NULL,
  `date_activity_pro` date default NULL,
  `date_entry_sii` date default NULL,
  `position_coeff` varchar(30) default NULL,
  `manager_id` int(11) default NULL,
  `position_id` int(11) default NULL,
  `remuneration_id` int(11) default NULL,
  `MISC_id` int(11) default NULL,
  `career_id` int(11) default NULL,
  `mission_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `bu_id_idx` (`id_bu`),
  KEY `picture_id` (`id_picture`),
  KEY `manager_id` (`id`),
  KEY `position_id` (`position_id`),
  KEY `remuneration_id` (`remuneration_id`),
  KEY `MISC_id` (`MISC_id`),
  KEY `career_id` (`career_id`),
  KEY `mission_id` (`mission_id`),
  CONSTRAINT `bu_id` FOREIGN KEY (`id_bu`) REFERENCES `bu` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `career_id` FOREIGN KEY (`career_id`) REFERENCES `career` (`idcareer`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `manager_id` FOREIGN KEY (`id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `MISC_id` FOREIGN KEY (`MISC_id`) REFERENCES `misc` (`idactivity_prestation`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `mission_id` FOREIGN KEY (`mission_id`) REFERENCES `mission` (`idmission`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `picture_id` FOREIGN KEY (`id_picture`) REFERENCES `picture` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `remuneration_id` FOREIGN KEY (`remuneration_id`) REFERENCES `remuneration` (`idREMUNERATION`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Francois-Xavier','DE WEVER','00112',1,1,'fdewever','-5537611252501867718','fx.DW@sii.fr',NULL,NULL,'2016-01-01','0606060677','cinema','2016-02-06','2000-01-01','2.1/115',9,3,1,1,1,1),(4,'Thomas','NUTI','11234',1,0,'abourre','-5537611252501867718','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,3,1,1,2,2),(7,'SÃ©bastien','VANOUTRYVE','164834',1,0,'svanoutryve','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7,3,2,2,1,1),(9,'Aurélien','DIERICK','1111',3,1,'admin','-6727425897441563272','admin-lille3@sii.fr',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(10,'Thierry','CHEVALIER','123456',1,1,'tchevalier','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10,4,3,1,2,1),(11,'Guillaume','LHOMME','23659',1,1,'glhomme','-1542838503490473174',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,11,3,2,2,2,2),(14,'Jason','TOULOTTE','776635',4,0,'jtoulotte','-167635408306149562814427877325892104405','jtoulotte@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14,3,3,1,2,1),(17,'Ingrid','DUPONCHEL','225533',5,0,'iduponchel','-78204856685539010787712896744289296891','iduponchel@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,17,1,1,2,1,NULL),(18,'Hervé','Hinaut','9966552',1,0,'hhinaut','-5807793128217589451','h.hinaut@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,18,1,2,1,1,NULL),(19,'Maire','Lanquetin','662244',5,1,'mlanquetin','-5537611252501867718','mlanquetin@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,19,5,1,2,2,NULL),(20,'Julien','Masset','72938',1,0,'jmasset','-5537611252501867718','jmasset@ssii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20,3,3,1,2,NULL);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_expsign`
--

DROP TABLE IF EXISTS `cv_expsign`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_expsign` (
  `id` int(11) NOT NULL auto_increment,
  `client` varchar(255) default NULL,
  `mission` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_expsign`
--

LOCK TABLES `cv_expsign` WRITE;
/*!40000 ALTER TABLE `cv_expsign` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_expsign` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` int(11) NOT NULL auto_increment,
  `code` varchar(45) default NULL,
  `trs_label_key` varchar(45) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES (1,'Manager','manager'),(2,'Stagiaire','stagiaire'),(3,'Developpeur','developpeur'),(4,'Directeur','directeur'),(5,'RH','rh'),(6,'Comptable','comptable'),(7,'Commercial','commercial'),(8,'Secrétaire','secretaire');
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cv_school`
--

DROP TABLE IF EXISTS `cv_school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cv_school` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `title` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cv_school`
--

LOCK TABLES `cv_school` WRITE;
/*!40000 ALTER TABLE `cv_school` DISABLE KEYS */;
/*!40000 ALTER TABLE `cv_school` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-19 16:36:46
