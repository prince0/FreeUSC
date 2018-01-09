<?php
$con=mysql_connect("localhost","lafeimme_prince","1993Prince");

if(!$con)
die('could not connect: ' .mysql_error());

mysql_select_db("lafeimme_freeusc",$con);
// array for json response
$response = array();
//$response["type"] = array();
$response["users"] = array();
//$response["stype"] = array();
// Mysql select query
$result1 = mysql_query("SELECT * FROM users");

print $result1
echo $result1;

while($row = mysql_fetch_array($result1)){
// temporary array to create single category
print $row;
echo $row;
$tmp = array();
$tmp["email"] = $row["email"];
$tmp["prob_name"] = $row["prob_name"];

// push category to final json array
array_push($response["users"], $tmp);
}
//$result2 = mysql_query("SELECT * FROM mst_prob_stype");
//while($row = mysql_fetch_array($result2)){
//// temporary array to create single category
//$tmp = array();
//$tmp["prob_stype"] = $row["prob_stype"];
//$tmp["prob_stype_name"] = $row["prob_stype_name"];
//$tmp["prob_type"] = $row["prob_type"];
//// push category to final json array
//array_push($response["stype"], $row);
//}
//
//// keeping response header to json
//header('Content-Type: application/json');
//
//// echoing json result
echo json_encode($response);
?>