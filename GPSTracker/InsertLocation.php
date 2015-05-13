<?php

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

include './db_connection.php';

$imeiNumber = "355361059228327";
$latitude = 10.20;
$longitude = 25.20;
$date = "2015-05-02";
$time = "12:22:32";




$sqlInsert = "insert into Location values('$imeiNumber','$latitude','$longitude','$date','$time') ";

$query = $conn->query($sqlInsert);


//header("location:login.php");


