<!DOCTYPE html>

<!-- Logan Strong, ISS4014-1 SP24 - Data Base Systems And Web Integration, April 11th, 2024 -->
<html lang="en">
   <head>
      <title>ScifiFanPage</title>
      <style>
         body {
            background-image: url("Background2.jpg");
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            background-attachment: fixed;
            color: rgb(255, 233, 233);
         }

         .content {
            text-align: center;
            padding: 50px;
         }

         ul {
            list-style-type: none;
            padding: 0;
            margin: 0;
         }

         li {
            display: inline-block;
            margin-left: 15px;
         }

         li img {
            width: 350px;
            height: 550px;
         }
         table {
            width: 100%;
            border-collapse: collapse;
         }
         th,
         td {
            border: 3px solid rgb(74, 132, 155);
            padding: 8px;
            text-align: left;
         }
         h1 {
            color: rgb(5, 190, 247);
         }
      </style>
   </head>

   <body>
      <!-- body has a background style in the form of an image and most text displayed on it is white -->
      <div class="content">
         <h1>Top 5 Best SciFi Films And Why</h1>
      </div>
      <?php
         $DBName = "fanpage";
         $dbc = @mysqli_connect("lstrong.clo66w4iezhq.us-east-1.rds.amazonaws.com", "admin", "password", $DBName); 
         $sql = "SELECT * FROM pic";
         $rs  = mysqli_query($dbc, $sql); 
         $imArray = array(); //Array that holds each individual image path in from left to right order
         while ($image = mysqli_fetch_assoc($rs))//filling the array with every img path element from the pic table 
         {
            $im = $image["img"];
            $imArray[] = $im;
         }
      ?>
      
      <ul>
         <!-- List of my poster images -->
         <li><img src=<?php print $imArray[0]?> alt="Gattaca" /></li>
         <li><img src=<?php print $imArray[1]?> alt="The Thing" /></li>
         <li><img src=<?php print $imArray[2]?> alt="Alien" /></li>
         <li><img src=<?php print $imArray[3]?> alt="The Matrix" /></li>
         <li><img src=<?php print $imArray[4]?> alt="logan's Run" /></li>
      </ul>

      <?php
         $sql = "SELECT * FROM note";
         $rs  = mysqli_query($dbc, $sql);
         $noteArray = array(); //Array that holds each individual note in the table in row and column order
         while ($row = mysqli_fetch_assoc($rs))//filling the array with every note element from the note table 
         {
            $note = $row["note"]; 
            $noteArray[] = $note;
         }
      ?>
      <table border="1">
         <!-- Table with headers for movie titles and 3 reasons for each being my favorite -->
         <thead>
            <tr>
               <th><?php print $noteArray[0]?></th>
               <th><?php print $noteArray[1]?></th>
               <th><?php print $noteArray[2]?></th>
               <th><?php print $noteArray[3]?></th>
               <th><?php print $noteArray[4]?></th>
            </tr>
         </thead>
         <tbody>
            <tr>
               <td><?php print $noteArray[5]?></td>
               <td><?php print $noteArray[6]?></td>
               <td><?php print $noteArray[7]?></td>
               <td><?php print $noteArray[8]?></td>
               <td><?php print $noteArray[9]?></td>
            </tr>
            <tr>
               <td><?php print $noteArray[10]?></td>
               <td><?php print $noteArray[11]?></td>
               <td><?php print $noteArray[12]?></td>
               <td><?php print $noteArray[13]?></td>
               <td><?php print $noteArray[14]?></td>
            </tr>

            <tr>
               <td><?php print $noteArray[15]?></td>
               <td><?php print $noteArray[16]?></td>
               <td><?php print $noteArray[17]?></td>
               <td><?php print $noteArray[18]?></td>
               <td><?php print $noteArray[19]?></td>
            </tr>
         </tbody>
      </table>
      

      <!-- Hyperlink to external scifi resource -->
      <p>Click <a href="https://www.scified.com">here</a> to visit SciFied.com where you can keep up to date on the latest films and other things SciFi!!!.</p>

      <!-- Form that takes viewers email and favorite film as a message -->
      <h2>If you'd like to share your favorite SciFi Film, put it and your email down below!</h2>

      <?php
         $Display = true;

         if (isset($_POST['Submit']))
         {
            $email = $_POST['email'];
            $message = $_POST['message'];

            $conn = $dbc;
            if (!$conn)
            {
               die ("Connection failed: ". mysqli_connect_errno() . mysqli_connect_error());
            } 
            //inserts the email into the email section of the submission table as well as the favorite film message
            $SQLString = "INSERT INTO submission values ('" . $email . "','" . $message . "');"; 
            if (mysqli_query($conn, $SQLString))
            {
               echo "<p> Thanks for you submission";
            }
            mysqli_close($conn);
            $Display = false;
         }
         
         if ($Display) //for taking away the form after a submission was made
         {
      ?>

      <form action="FanPage.php" method="post">
         <label for="email">Email:</label><br />
         <input type="email" id="email" name="email" required /><br /><br />

         <label for="message">Favorite SciFi Film:</label><br />
         <textarea id="message" name="message" rows="1" cols="40" required></textarea><br /><br />

         <input type="submit" name="Submit" value="Submit" />
      </form>
      <?php
         }
      ?>

      <footer>Made By Logan Strong: Last Updated April 11th 2024</footer>
   </body>
</html>
