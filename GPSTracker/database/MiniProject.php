<?php
# FileName="Connection_php_mysql.htm"
# Type="MYSQL"
# HTTP="true"
$hostname_MiniProject = "localhost";
$database_MiniProject = "GPSTracker";
$username_MiniProject = "root";
$password_MiniProject = "1234";
$MiniProject = mysql_pconnect($hostname_MiniProject, $username_MiniProject, $password_MiniProject) or trigger_error(mysql_error(),E_USER_ERROR); 
?>