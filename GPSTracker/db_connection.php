<?php
        $mysql_host = "localhost";
        $mysql_database = "gpstacker";
        $mysql_user = "root";
        $mysql_password = "";

// Create connection
        $conn = new mysqli($mysql_host, $mysql_user, $mysql_password, $mysql_database);
// Check connection
        if ($conn->connect_error) {
            die("Connection failed: " . $conn->connect_error);
        }

?>