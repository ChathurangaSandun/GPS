<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<?php
?>

<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <?php
        include './db_connection.php';


      
          $sql = "SELECT * FROM Person left join Location on Person.imeiNumber = Location.imeiNumber order by Location.time asc,Location.time asc";
          $result = $conn->query($sql);



          if ($result->num_rows > 0) {
          // output data of each row
          while ($row = $result->fetch_assoc()) {
          $name = $row['personName'];
          $latitude = $row['latitude'];
          $longitude = $row['longitude'];
          $date = $row['date'];
          $time = $row['time'];
          echo "<br> Name - " . $name . "<br>lat -  " . $latitude . "<br>lon -   " . $longitude . "<br> Date -  " . $date . "<br> Time - " . $time . "<br>";
          }
          } else {
          echo "0 results";
          }
         
        
        ?> 


    </body>
</html>
