<html>
<?php
    /* 
        Logan Strong: helped with the database sql and did most of the php coding. Estimated 3 to 4 hours

    */
?>
<head>
    <title>Finish the Lyrics!</title>
</head>
<style>
body {
    background-image: url('Images/Background.png');
	label, textarea, h1, h2, h3, p{
		color: red;
		font-family: georgia;
		text-align: center;
		font-weight: bold;
	}
	.center {
		display: block;
		margin-left: auto;
		margin-right: auto;
	}
	form, div {
		margin-left: auto;
		margin-right: auto;
		width: 50%;
	}
	input[type=submit] {
        background-color: lavenderBlush;
		font-family: georgia;
        color: darkRed;
		font-weight: bold;
    }
	
}
</style>
<body>
    <?php
    $DBName = "website";
    $dbc = @mysqli_connect("lstrong.clo66w4iezhq.us-east-1.rds.amazonaws.com", "admin", "password", $DBName); 
    $value = 1;//keeps track of the iteration value (determining which question to display)
    $score = 0;//keeps track of players score
    $correctChoice = 0;
    $Display = true;//for refreshing display when the submit button is clicked
    $Finished = false;

    if (isset($_POST['Submit']))
    {
        unset($_POST['Submit']);
        $radioVal = 5;
        $Display = false;

        //query to grab the turn and current score and update it in later calls
        $sql = "SELECT * FROM PLAYER where PLAYER_ID = 1;";
        $rs  = mysqli_query($dbc, $sql);
        $row = mysqli_fetch_assoc($rs);
        $value = $row['PLAYER_TURN'];
        $score = $row['PLAYER_SCORE'];


        $sql = "SELECT * FROM QUESTION where QUESTION_ID = $value;";
        $rs  = mysqli_query($dbc, $sql); 
        $row = mysqli_fetch_assoc($rs);
        $correctChoice = $row['CORRECT_CHOICE'];
        
        if (isset($_POST['choice']))
        {
            $radioVal = $_POST["choice"];
        }

        if ($correctChoice == $radioVal)
        {
            $score++;
            $sql = "UPDATE PLAYER SET PLAYER_SCORE = $score WHERE PLAYER_ID = 1;";
            $rs  = mysqli_query($dbc, $sql);
        }

        echo "<p>Score: ".$score."</p>";
        $value++;


		if ($value <= 10)
		{
			echo "<p>Question ".$value."</p>";
		}
       if ($value > 10)
       {
            $sql = "UPDATE PLAYER SET PLAYER_TURN = 0 WHERE PLAYER_ID = 1;";
            $rs  = mysqli_query($dbc, $sql);
            $Finished = true;
       }
       else
       {
            $sql = "UPDATE PLAYER SET PLAYER_TURN = $value WHERE PLAYER_ID = 1;";
            $rs  = mysqli_query($dbc, $sql);
       }
    }

    if ($Display == true)//for saftey like if the page is closed or reverted
    {
        $sql = "DELETE FROM PLAYER;";
        $rs  = mysqli_query($dbc, $sql);
        $sql = "INSERT INTO PLAYER VALUES (1, 'player', $score, $value)";
        $rs  = mysqli_query($dbc, $sql);
    }

    
    //this code handles all the display factors for each question
    if ($Finished == false)
    {

        $sql = "SELECT * FROM QUESTION where QUESTION_ID = $value;";
        $rs  = mysqli_query($dbc, $sql); 
        $row = mysqli_fetch_assoc($rs);
        $question = $row['QUESTION'];
        $choice_1 = $row['CHOICE_1'];
        $choice_2 = $row['CHOICE_2'];
        $choice_3 = $row['CHOICE_3'];
        $choice_4 = $row['CHOICE_4'];
		$image_path = $row['IMAGE_PATH'];
		echo "<h2> Guess the lyrics! </h2>";
		echo "<img src='Images/$image_path' alt='The song cover' width='300' height='300' class = 'center'>";
        echo "<p>".$question."</p>";
        ?>

    <form action="game.php" method="post">
		<div>
        <input type="radio" id="choice_1" name="choice" value=1>
        <label for="choice_1" ><?php echo $choice_1 ?></label><br>
        <input type="radio" id="choice_2" name="choice" value=2>
        <label for="choice_2" ><?php echo $choice_2 ?></label><br>
        <input type="radio" id="choice_3" name="choice" value=3>
        <label for="choice_3" ><?php echo $choice_3 ?></label><br>
        <input type="radio" id="choice_4" name="choice" value=4>
        <label for="choice_4" ><?php echo $choice_4 ?></label><br>
		</div>
		<br>
        <input type="submit" name="Submit" value="Submit" class = "center" />
    </form>
<?php
    }   
    else
    {
        
        echo "<p>Finished!!!!</p>";
        mysqli_close($dbc);
        //goes to the scorescreen php that displays a leaderboard
?>
        <form action="scorescreen.php" method="post">
        <input type="hidden" id="score" name="score" value=<?php echo $score ?>>
        <label for="message" class="center">Enter your initials here!</label><br />
        <textarea id="message" name="message" rows="1" cols="3" class="center" style="background-color:lavenderBlush; color: darkRed" required></textarea>
		<br>
        <input type="submit" name="Enter" value="Enter" class = "center" />
        </form>

<?php
    } 
	if ($score > 1 and $Finished == false)
	{
		echo "<br><br><br><br>";
		echo "<img src='Images/MarioNSMBUDeluxe.png' alt='...' width='7' height='10' style = 'margin-left: 1%'>"; //Whoever finds the secret Mario will be rewarded.
	}
?>

</body>
</html>