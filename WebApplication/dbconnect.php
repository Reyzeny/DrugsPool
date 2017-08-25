<?php
$error = 'Could not connect';
$db_host ='localhost';
$db_user ='root';
$db_pass ='';
$main_db ='drugdb';

$dbconn = mysqli_connect($db_host, $db_user, $db_pass, $main_db);
if(!$dbconn){
	die("Could not connect".mysqli_error());
}

?>
