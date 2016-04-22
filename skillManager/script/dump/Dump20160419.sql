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
INSERT INTO `picture` VALUES (1,'1111',''),(2,'11234','ˇÿˇ‡\0JFIF\0\0\0\0\0\0ˇ€\0C\0		\n\r\Z\Z $.\' \",#(7),01444\'9=82<.342ˇ€\0C			\r\r2!!22222222222222222222222222222222222222222222222222ˇ¿\0\0p\0ñ\"\0ˇƒ\0\0\0\0\0\0\0\0\0\0\0	\nˇƒ\0µ\0\0\0}\0!1AQa\"q2Åë°#B±¡R—$3brÇ	\n\Z%&\'()*456789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫¬√ƒ≈∆«»… “”‘’÷◊ÿŸ⁄·‚„‰ÂÊÁËÈÍÒÚÛÙıˆ˜¯˘˙ˇƒ\0\0\0\0\0\0\0\0	\nˇƒ\0µ\0\0w\0!1AQaq\"2ÅBë°±¡	#3Rbr—\n$4·%Ò\Z&\'()*56789:CDEFGHIJSTUVWXYZcdefghijstuvwxyzÇÉÑÖÜáàâäíìîïñóòôö¢£§•¶ß®©™≤≥¥µ∂∑∏π∫¬√ƒ≈∆«»… “”‘’÷◊ÿŸ⁄‚„‰ÂÊÁËÈÍÚÛÙıˆ˜¯˘˙ˇ⁄\0\0\0?\0Ë◊Ø5/Zb£S¨gïÌ#√IÄ8Ë)¡©B¶óÂÒ@Ïƒˆ•¿ı¨ùgƒ⁄>ÇjwÒ¿Œ2©ÇÃG<ÌPN8#8≈WµÒfâ|ÅÌ/M◊ÓÃ•-†íWD≤*ñQí:Å÷¶SÑwcT‰ˆW7∑q≈=rNk\Z€Sª‘YEùì≈	#3Ã‡d‰Ì)Ω[ÜJÿ3-º(˜;b˘Ir	(òRÃK`\0†)˘é;§\nQîdÆ∂ß$Ï«êix≈\nÈ<I,NØ®eu9 É‹Rlc⁄¨MXçïò˚Rj¬FGZdÛ5π≤∫∏Àøó«◊{≠\rÿ.0Gä`äã\\‘≠4}>ÊÒÆ≠àà\0±M!Å‰}ªäÆ·Ü¿˛È=˚åW+·_]¯ÜÚın!∑∂ä,yHàÃ«s`n}€s–p>lÒ“π+cËQÉúﬁã}‰uS¡‘úîﬂÕS(CL`qQiZµ¶≤.ÑÑñ“ò‰ç‘´CÇ¡Ò‘g†PzW\\$•%≥9ÂM≈¥ &<ı®^ˆ´Ïû‹SDˆ™%¿ÕkqÈEhèLQ@Ωê´Ï*U*ÏzxìS•íÁÅYÛ#©S3l{qS[YIpÂcC#ªh8Õi˝êc\0P.·—1=¡Ÿ]œE\0dí{V5€ï)E;]n∑^ûe”¶î”zü?xÔ¿^.óƒzé©˝ä´k,¯ç≠ô\0+–ª≥í9\'I5—|:æ©®h6skó7Kè&œO8Ut%â2eêñ$)8=NAÁ⁄5õΩµVª›î\rÂ‡eN:8Œ:ëT¨lƒvãÙåmÙÌ^\nº\'ä˙¥‡˘b¥o[µ˝iËzU‚’/i	YΩ“ÏWÚ˘˜•\Z∫m∑›‚§çéïÙúËÚ˝ô√k~\Zø∂:üÖ.>…©±2=´ˆ{£å©·\\Cqì◊©aÁø<Qc`©=Ï1ﬂíﬁdoèäë¡±Á⁄æÇ[LïÂü˛«™;Î∫B,WπÔ @úºì\"ˆ9\'‘dınzœñ<—f¥‡õIó>|@á∆[+∏„∂’bO.0Dr«û´íH# O∏œ!{ì\r|ß¶ô¥ç~´y%µô^7#ê¿ÁßOC_\\iç©aku\\FÆ9€ûŸˆÈE\ZÕ«ﬂJQR¥JìËÍ:\\±›B$∂ôJ?ƒ?œÚÆiım√^ñ+[{O&GÜ&2õ‰F*Á$ñ‰´c,OAöıÉ\Z$JùF}+Â?â6Õ¶¸B÷lbf6∑Mˆ∏◊Ã›Ãúø”/ªé‹WïFU\'çîÁ+¶¥]≠˛gD“ßG›Zı:á:Îj˛3’|≥ Ük_9„p	¨†ˇ\0¿€ÛØP zWá|∫éºπY.lûÜﬁ¨\næ=æTo ΩÏ[fΩ∏NËÂp±Sj˜¿§!zû[l*≥™∏πYåÄˆ¢§{«9¢ü2+.ñ;¿ÕYB¨•ëâ´1cåöŒ∆ó4÷EÎûÒç¯ä_AÖ^]bÿÆW~‘Ç§Ù≠m§^=¨xêÎ¥ÎfÌ4ΩA é.yêzÜ–z∆¥/b„+;û◊©9ílêsí3ûﬂOÛ÷©õ§≤Ç[óÊ8êªëŸG$˛£∏∫ÛX∞#h¿©≠1ºm‰\\¥®FN⁄ö NMñ≠ØÌÓ°I‡ñ9boª$lO–ä∞◊1Ì¿Ø“<-¨¯~k¥≤Òoÿë%um±´¬‡õ‹;l\r¿„ék°¥Ò˙Ÿ√0’¶≥πêsX+ç‹teqÚÙÍÁ=+¶2Ñôé©jz3\\™)w¿P2I=+ãÒáå∆ìlÊ¥ã(ÓrX0UpI¡Œ~Íúz›«Rk◊◊Ø*$zuºÃ!~c€«◊8¿Á⁄º”«˙≤Îö˘Ì∏£Ç√ëÚú`S…∏R◊D;•ú≈‘—ﬂjR\\\0∞≥€ÍxŒ1¿…œø\n˙?·Œªk7Ö·c∞≠ì(Æ∂ûUàÌ…8ı€◊Æ>c≥O6Ì8…$é2y¸¯ØJgâ-Ùñº≤öQ\Z‹EÅ9ëdÁ∞\n_è\\UrsGòÀüíj\'–∫•˙ã`Ò6A\r|ÂÒ5ëº{á\0\r=N{ìΩˇ\0œ·^Õ«ùlÏÆ29Ø)¯µ§NœZâwDÉ»î®\'nNTûÿ…#>§uœÒ√(TçE–ﬁ§ú†„‹Â<)r⁄wƒ-Ú—t∑inCÚì˜l\'8˜≈}8FŒq_˝™x‰WéGI\"mË pTé‡ız˚Wÿ6:º\Z¶èg4q›€§Íç˜î:Ü\0„ø5“•y;∏≈&8°îúPILsO[ø+=9ß	CçÊ¥‘e	¡ËO·E_Û¢n®*(∏XØ#jgß4r&~B+•é(Ä\në≠Q¡˘xÆ¨k±\\á\r≠Í2È:%ﬁ†Å\Zh£˝ H¨UÂ?,jqŒïG^£≠xÔÇº%s•x¶ Úı3o‰4∏k>L|Óæb=∂üZˆ[Àu>ã†ZWø∫fó*≠àcBIπ ≥F‹~\\gú\Zæ!≥éﬂRaRŒŒ.2ƒ∂¬“)9=qµRy•)©4.V>Y\0å8ÙÌY∫«å4Ô	È/ux€Âl¨Í~iXvˆß∑π ˚NË¿Ë@Ô^‚õ€ˇ\0¯‚k8Âïf˚º$Å–„Ø\0e≤rzg–U‘i ãÏO™x√Q◊ßyÓÊ&i•˘#â0´”Gs¬è\\íz◊U√èÎz\"\\&êÒJf¬≈)X€gL∂ˆ∆3÷Ω·ß√}3√–≠≈ -÷Æâñπ9€‡AX«`0Fqìì–MXƒkÅ“≤u-∞Ωï›ŸÚÂ‘¯>∆ÁMökòÔÓ>{≥!⁄Ä€@Îœﬁ Á$ma¡√ÍW>tÔ!aª9@pÍx„ﬂèZÓ>$ﬁœq„-Yd›\'óq$‰˘Ö@‹6‡Ù\'ßL◊ùL˚¶%§‹	%∂Ò◊ÎW{\"bØ/Bm9›%bõ±É¿œ<~¢§éWé‚W\'Ç«Ò˛qUP∏;AÍ˛ïŸ›Ëÿ¯ﬂVô	ùÓbRÒ>”âcôêìÉ–™d{Œi©r§9E6¸ÕØ¸F˛Õçl5_2KppíÅñàwœv^˝œaûun£∏‘êJíG\'î»ÍŸª‘Çq^7™isi›‰ •Ã)<“Ë¿0»‰Ç28»ÎNóYªìE])‹Ω∏üÕwBA»˜9˙˝x—NËVkCs…+∏◊—ﬂÔ?¥>[√\rîÚ¿Ïz1-Êd~¯\Z˘…∏\\6:˛5Ó_≥û≥∂˜XÙç##†ºÖx⁄ÖHG˜…\r˝ÒXs8jmkû¶÷≤ªÒ¸E]∂ÖPa‘[RB?ÑUSfÃ€âßÌπñ¢Â∞”mÚä* [`u¢≤ˆûcÂ#‹ôÎS§√V0ä:\ZêÄx4ò&Œj‰˝ª‚ç†í)Z^ñ”≈*éŒÂ\n±˙Eê:Òı™∫¢õÔj3C¨∂˙j€8<Æ˝ﬁnqû”å„ì«j––„ëxûwwiÏ0(-ê®∂–∏\0v˘§s¯“YÃöUæ£ys<ì]O\Zñ«(„Ò–¿E	.Éı8f&Ãd¸æ’OMÓç¶Îrk0€ªïãºÆ≈∞Õ◊8ûˇ\0^∆¨jS´\\ªFŸRw\0OÈT û‚ˇ\0P∑∑∂Wñf}©\ZåÓ$u¸9Á†≠\'Ÿô¶zØá…a,ònf 1@ß∑_÷∑Ωj¶ïbtÌ.ﬁ—ﬂ{∆ø3g9c…«åìOº∏[;õÇ@Ú¢g…Ë0	¨∑4>IÒvØ&´‚+ÀŸUﬁGlaqœ\\~c<◊\"Á$0<û£ﬁ∫]Mdq,ä¯EŒ‰%≤LÄzœ˚Bπß\01‰ìí2kilcH——4Û®j÷∂ÿ`é„ySç™9cüe…¸+ÍØhzßÑÔ-µKD∏∂‘Xâ#ì£†‡tËCdÇ0A¡¿Øõ¸	lœ‚H2	Öÿn˚ŸF?ï}weoüe§@mâ1úu?èZ*iªïy∂yç¸£iv6⁄]µ´√¶òèóÛñ(˚â%Y≤s»?é:q^\r©YK§ﬂ…c#FUÒ¥0<É˝>£⁄æºÒéí˙∆Ü˛Bn∫∑ÃëåXwQéÁ˘Å^	≠hi≠Ÿ$1[òIhôÜÓ‡èCÌÏ}´869nyÄ]ƒÆNI¿ÔÕvuÙüä:“«#)ú€m»iU¢.“πÕﬁµà°πYMæ®…B T8ËƒT⁄]‰ûÒuÖ˝’ª;Xﬁ«4ëÉÀò‹1\0ü\\u´j∏\'ÔX˚wöCÅQó¡¶ô+û∆∑_T≤zQU +ú~/æ˝\\â©áå.…πLˇ\0Ω\\íπ8„Û©˛bzä.¿Ëìƒ7\"‚i£ÜöVﬂ&’¡v⁄$˜8U@=+S’‰˛ â§\'|è3∫ñ˚§ ƒèn›?jµ≈ﬂŸÌ%∏⁄“yhœµI¿Œ\0ıÆ;_’O“¨ûhÊM—©ÚæÛ`9˙˚c≠)∑πùGe†ÎùJKÉÚπDŒ}r?*È¸+Ÿ^≠Ú\0^0JÓ	˝F*··gY„Y°tiIëvíß∏ùØJÙ*k`ÄÏ759Z◊3¶õñßaˇ\0	EÔô∏àÒÈQ^¯ÜÊ]7Q.ëÖ[+á¡<|±1¸´…ÅúúT\ZîÑh∫ñ2wXŒ1Î˚¶¨÷Æ«C⁄ÁÜj0øŸÃícÁÇÄwtÍ˛ΩÑÏwúÁ$üzÌu€[[}Kc;4üg±ı∏∂yœr;t\0ıÌ«§gqÃâÚ˝‡›?ˆ≠‰ùëÖ\'k£’>Z«\n.§©\\Õ6F„ùàÑΩ;úÁË+◊◊ƒ∑´&HCÌ“º≥·¥,4%ïîmÇ∂]ƒ|‡ŒªLå‰}ÈVñ©.≈“Z6t)‚´¥f%#l˛Æ7ƒörkrjv»±\\Ädí5Âd#íG°¿$˙„÷¶{õè9ïm∆ﬂÛß”4ÿn.å Ñ6Qï≥˛M`§[IËymﬂá‚\Z˙Í:≈a3°˘∑6Ï∞˚súıœ~9Ø g◊ÓÊ$12úÊªø/ˆe“®˝≈•Ò&/Ó§ÉÜ^xx≈y‡◊ü^C)ªîyr;ÌÛ\'q∆‹íN:„$˝\rnöp±ÑSU5>Ü/é.¿⁄JõDqn†7«îÍBÉ[m„[Ä8ÅAˇ\0zºè·ΩƒØ·…bmÊ(ÓF-ê\nJÅ€Á”ÊıÕuÆŸ}£®˝k⁄fÁT|mrüz˘—\\ÉíéMs±WΩM;z3ﬂX˛Ÿ‰¥rƒBúâq¡œ9Á∑FE=›É ë\"≥™ñ⁄ŸB§rF=á?ó®¨€YY\nêËÿ9‡„$•yu∫_Íæ+±∫÷5;%n∂í˜1>pcwv;éΩ+“Ωç‹KòÇ®#z?|Òí£˘3…˚ƒcÂ¨+ˇ\0Y]y‡«\nÄÍæq∂äπäÁÓÆA∆‚9Ó:SÊ∂ÄÃ/â\Zî–j˙L∞8˝‹%–Å‘Œ	G∂{üZÙ[€mN….‡tñ)p+”ÈÏzÒ⁄∏õ_\0Ÿb%7.íI∑»€l∂≤I«#B)˜^”b±˝™VØ⁄0ß)º„	ñ¿ åıÈMI=.G±€\\Àk¶Y…s<Ü¢…rŒƒıô¨k\Ztû\Zª∏[§tXùókﬂé}	¬˚Áä¬:$∑«[]†â7§ç|¿0»∆Iã=6ûOB1ÈVµ	‹ÍV˚?µódòc\Z¬hÏ¬åúÓ¿ c8õuì}ÊﬁÁXÒ¶ñœ hÌ‡éo/sy?ªR„o8!≤„Ê™ÔãÙç\'√÷6ë€•»πrAyÂ™ÚI8¿<≤å{rt-|	ycs≥LÒ\0UiFIÂ´∂Ywg∏9«é¸¶•‡=CPdyÔ¢ëÿn⁄.\ZVN9‡®Å–zx5~—˜*⁄∆ﬂÉ.d∫Â™ÈÎÑVY…*I É˛q[1]J≠#>°ß®Ha‹xÍ\0r}Ä5«Ÿx\Zk(&é/ﬁ[Ì <0Ç73\09<Iß≈k\\¯BÌm^·uõããá\0ôòR9ﬂÛwË:Á†¨€Rw∏ıéâ\Zó:•úKˆçRDí˝Úƒ7î‡ÌÍ9ÈûE&€eå0‘nÊ˘2§Ãpÿ<údÈ¡Õsr¯ﬁÑJxﬁE€ÂGe¬q»,8¡<˜˙ÒNü¡LXøµgú˝ôW P¡_h\'7cjÙ˙Òåáe‹^˜bßç‰”Ô¥kX≠ÁÛ&í„˜\"Vÿ™X.Êbƒl‡\'ﬂ∆Aœ@+#√≥	¸Gw8éuB—ƒà≈rÃƒÂp∆’sÓ‘ç5¯wh.åR^Äç)LG*Ä∞À|ﬁ√s…‰q∆Ñ>	—ç¥ôédí<±)\"7NŸ…˘±”úû“Í^ÑpŸiWMqÈÎ+~ÒEÀm8‹~Rv‡{«ñ]FÌ÷‰Ÿ˝ï@%ãKrƒm+üóÊ\0‰‡u\0uıƒÌ‡≠%ƒã◊Öà?ò“Üﬁ€±¬ÌS˜O‡}FM=<9£8-—Áúƒ]X	∏„€oûH\'<sπ>Û(3ƒEgÛld˘NÿÁ9€ísµÄ$Å∑ü`UÎ«I-¢2´GáI•⁄ª≥úç§òü^;óª‹i;jø3ˇŸ');
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
INSERT INTO `person` VALUES (1,'Francois-Xavier','DE WEVER','00112',1,1,'fdewever','-5537611252501867718','fx.DW@sii.fr',NULL,NULL,'2016-01-01','0606060677','cinema','2016-02-06','2000-01-01','2.1/115',9,3,1,1,1,1),(4,'Thomas','NUTI','11234',1,0,'abourre','-5537611252501867718','',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,4,3,1,1,2,2),(7,'S√É¬©bastien','VANOUTRYVE','164834',1,0,'svanoutryve','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,7,3,2,2,1,1),(9,'Aur√©lien','DIERICK','1111',3,1,'admin','-6727425897441563272','admin-lille3@sii.fr',NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL),(10,'Thierry','CHEVALIER','123456',1,1,'tchevalier','1234',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,10,4,3,1,2,1),(11,'Guillaume','LHOMME','23659',1,1,'glhomme','-1542838503490473174',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,11,3,2,2,2,2),(14,'Jason','TOULOTTE','776635',4,0,'jtoulotte','-167635408306149562814427877325892104405','jtoulotte@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,14,3,3,1,2,1),(17,'Ingrid','DUPONCHEL','225533',5,0,'iduponchel','-78204856685539010787712896744289296891','iduponchel@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,17,1,1,2,1,NULL),(18,'Herv√©','Hinaut','9966552',1,0,'hhinaut','-5807793128217589451','h.hinaut@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,18,1,2,1,1,NULL),(19,'Maire','Lanquetin','662244',5,1,'mlanquetin','-5537611252501867718','mlanquetin@sii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,19,5,1,2,2,NULL),(20,'Julien','Masset','72938',1,0,'jmasset','-5537611252501867718','jmasset@ssii.fr',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,20,3,3,1,2,NULL);
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
INSERT INTO `position` VALUES (1,'Manager','manager'),(2,'Stagiaire','stagiaire'),(3,'Developpeur','developpeur'),(4,'Directeur','directeur'),(5,'RH','rh'),(6,'Comptable','comptable'),(7,'Commercial','commercial'),(8,'Secr√©taire','secretaire');
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
