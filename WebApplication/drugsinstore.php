 <?php 
 include("dbconnect.php");
 ?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Drugs in store</title>
    <link rel ="stylesheet" href="css/style.css" />
    <link rel="shortcut icon" href="images/icon.jpg"/>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    
         <!-- NAV SECTION -->
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container-responsive">
<!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <h2><a style="color:#fff;" href ="index.php">Pharm-Drug.ng</a></h2>
        </div>
<!-- Collect the nav links, forms, and other content for toggling -->
  <div class="collapse navbar-collapse" id="#">
    <ul class="nav navbar-nav navbar-right">
      <li class="active"><a href="#"> </a></li>
      <li><a href="#"></a></li>
    </ul>
  </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- home section-->
<!-- home section-->
<!-- home section-->
<div id = "picture-sec">
     <div class ="container">
     <center>
     <div style="text-align: center; background:green; width:450px; -webkit-border-radius:30px; -moz-border-radius:30px; color: #fff;"><h1>Drugs Available In Store</h1></div></center>
        <div class = "row">
             <!--<div class="col-sm-6 col-md-4" id="mypicture">
                  <img src ="images/drugs.jpg" class="img-circle center-block"> 
             </div>-->
               </div>
               <div id="result">
            <?php
              //$sql ="SELECT `drug_name`, `disease_cure`, `drug_dosage`, `adverse_effect`, `manufacturer` FROM drug_tbl";
              $sql = "SELECT * FROM `drug_tbl`";
                $res = mysqli_query($dbconn, $sql);
                if((mysqli_num_rows($res)) > 0){
                 while($result = mysqli_fetch_array($res)){                         
                  $name = $result['drug_name'];
                  $disease =    $result['disease_cure'];
                  $doasage =    $result['drug_dosage'];
                  $effect =    $result['adverse_effect'];
                  $manu =       $result['manufacturer'];
                  $desc =       $result['drugs_desc'];
                  $link =       $result['drug_link'];
                  $link2 =      $result['drug_link2'];
                  $drug_url =   $result['drug_url'];

                  echo "<div style='width:650px'>"."<h3><a style=\"color:blue\" href=\"drugsfulldescription.php?drugs_id=$result[drugs_id]\" target=\"_blank\">$name</a></h2><h6 style=\"font-style:italics; color:#FF00CC; font-family:verdana\">$disease <br/><b>Manufacturer:</b>$manu<br /></h6></div>";
                  }

 
                   /* echo "<div style='width:650px'>"."<h2><a style=\"color:blue\" href=\"drugsfulldescription.php?drugs_id=$result[drugs_id]\" target=\"_blank\">$drugName</a></h2><b u style='color:red;'>Diseases:</b> $disease <br/><b style='color:red;'> Dosage:</b> $dosage<br /><b style='color:red;'style='color:red;'>Adverse Effect:</b> $effect .\"<br /><b style='color:red;'style='color:red;'>Manufacturer: </b>$manu<br /><br />"."</div>";
                  mysqli_free_result($result);*/
                }else{
                  echo "No record were found.";
                }
              //mysqli_close($dbconn);
              ?>
             </div>
             </div>
        </div>
    </div>
     <br>
         <br>
     </div>
    <hr> 

        <div>
            <div class ="row well text-center">
                <div class="col-xm-12 col-sm-4 col-md-3">
                   <strong> Medical Advice<span class="glyphicon glyphicon-arrow-right" style ="padding-left:20px;"></span></strong>
                </div>
                <div class="col-xm-12 col-sm-6 col-md-3 ">
                       <em> Self Medication Is Wrong </em>
                    </div>
                <div class="col-xm-12 col-sm-6 col-md-3 ">
                    <em>Make Sure you Consult a Doctor when feeling ill</em>
                </div>
                  
            <div class="col-xm-12 col-sm-6 col-md-3 ">
                      <em> Be carefull of over the counter Drugs </em>
                    </div>

            </div>
        </div>
        <div class ="col-sm-12 col-md-8 ">
            <h2 class="text-center page-header">Health Tips... <span class ="glyphicon glyphicon-user " aria-hidden="true" style="padding-left:10px;"> </span> </h2>
                <div class="about "><strong style ="color:gold;"> Pharm-Drugs </strong>advices you:<em><p>Eatat good food<p><br><p>Consult a doctor when ill.</p></p><p>Exercise daily</p><p>Always stay off quacks.</p>Visit only registered pharmaceutical outlets for drugs purchase. <br></em></div>
        </div>
        <div class ="row">
            <div class ="col-sm-12 col-md-4">
                <h2 class="text-center page-header"><span class ="glyphicon glyphicon-briefcase "  aria-hidden="true" style="padding-left:10px;"></span> Group C drug search</h2>
                <div class="bio">
                              <div class="col-sm-6 col-md-4 text-center" style="padding-top:60px;">
                 <h3> Pharm-Drugs.ng</h3>
                <span class="glyphicon glyphicon-map-marker" aria-hidden="true">Ikeja,Lagos state, Nigeria</span>
            </div>
            
             <div class="col-sm-12 col-md-4 connect center-block text-center" >
               <h5 class="page-header">Contact Pharm-Drugs</h5>
               <div>  <i style="padding-right:10px;"><img src = "images/fone.png" height="15px" width="15px" alt= "email"></i><em>  +(234)8068713465</em>
               </div>
              <div> <i style="padding-right:10px;"><img src = "images/email.png" alt="email" height="15px" width="15px" alt= "email"></i><em>Pharm-Drugs@gmail.com</em>
               </div>
                <ul class="list-inline list-unstyled">
                    <li><a href="https//:facebook.com/ Pharm-Drugs.7"><img src ="images/facebook.png"></a></li>
                    <li><a href="https://twitter.com/Pharm-Drugs"><img src ="images/twitter.png"></a></li>
             
                </ul>
        </div>
            
    </div>
  </div>
    <hr>
    <footer class="text-center">
      <div class ="container ">
        <div id="Pharm-Drugs">
            profer drug solutions... in a world of possibilities!
       </div>
          <div id="twit" style="font-family:tahoma;"> <img src ="images/twitter.png" height="30px" width="30px"> <a href="https://twitter.com/Pharm-Drugs"> @Pharm-Drugs </a>
                <p>
       </div>
       <div >
          &copy 2017 | All rights reserved</p>
        </div>
      </div>
    </footer>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 <!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
