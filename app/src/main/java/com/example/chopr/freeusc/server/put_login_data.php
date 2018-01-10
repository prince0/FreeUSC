<?php
$host='localhost';
$uname='lafeimme_prince';
$pwd='1993Prince';
$db="lafeimme_freeusc";
$con = mysql_connect($host,$uname,$pwd) or die("connection failed");
mysql_select_db($db,$con) or die("db selection failed");

$first_name=$_REQUEST['first_name'];
$last_name=$_REQUEST['last_name'];
$email=$_REQUEST['email'];
$sex=$_REQUEST['gender'];

$flag['code']="0";
if($r=mysql_query("INSERT INTO users (Email,First Name,Last Name,Sex) VALUES ('$email','$first_name','$last_name','$sex') ",$con))
{
	$flag['code']='1';
}
print(json_encode($flag));
mysql_close($con);
?>