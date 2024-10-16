<html>
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
	form {
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

    $name = $_POST['message'];
    $score = $_POST['score'];

    //inserts score and name to leaderboard db
    $sql = "INSERT INTO SCORE (PLAYER_NAME, PLAYER_SCORE) VALUES ('" . $name . "', $score)";
    $rs  = mysqli_query($dbc, $sql);

    $sql = "SELECT * FROM SCORE ORDER BY PLAYER_SCORE DESC";
    $rs  = mysqli_query($dbc, $sql);
    $count = 1;
    while ($row = mysqli_fetch_assoc($rs)) //displays every score and name in descending order
    {
        echo "<p>".$count; 
        echo " "; 
        echo " ".$row['PLAYER_NAME'];
        echo " ";
        echo $row['PLAYER_SCORE']; 
        echo " out of 10</p>";
        echo " ";
        $count++;
    }
?>
    <form action="game.php" method="post">
    <input type="submit" name="Play Again?" value="Play Again?" class="center"/>
    </form>


</body>
</html>