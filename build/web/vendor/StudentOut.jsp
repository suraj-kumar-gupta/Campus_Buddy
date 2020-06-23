<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Security Dashboard</title>

    <!-- Bootstrap CSS CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
    <!-- Our Custom CSS -->
    <link rel="stylesheet" href="SecurityDashboard.css">
    <!-- Scrollbar Custom CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

    <!-- Font Awesome JS -->
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js" integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ" crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js" integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY" crossorigin="anonymous"></script>

</head>

<style>
input[type=text], select {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
input[type=text2], select {
    width: 35%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type=submit] {
    width: 100%;
    background-color: #3390FF;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}
input[type=submit2] {
    width: 10%;
    background-color: #3390FF;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
}

input[type=submit]:hover {
   
}

div {
    border-radius: 5px;
    
}
</style>
<body>

    <div class="wrapper">
        <!-- Sidebar  -->
        <nav id="sidebar">
            <div class="sidebar-header">
                <h3>Campus Buddy</h3>
            </div>

            <ul class="list-unstyled components">
                <p1>CU Digital Outing System </p1>
                <li>
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Gatepass</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li class="active">
                            <a href="StudentOut.jsp">Student Out</a>
                        </li>
                        <li>
                            <a href="StudentIn.jsp">Student In</a>
                        </li>
                        <li>
                            <a href="#">History</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#">Profile</a>
                </li>
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Defaulters</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="#">Late comers</a>
                        </li>
                        <li>
                            <a href="#">Rule Breakers</a>
                        </li>
           
                    </ul>
                </li>
                <li class="nav-item">
                                <a class="nav-link" href="HostelDetailsSec.jsp">Hostel Details</a>
                            </li>
                <li>
                    <a href="#">Contact</a>
                </li>
                <li>
                    <a href="SecurityLogout">Logout</a>
                </li>
            </ul>

                </nav>

        <!-- Page Content  -->
        <div id="content">

            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <div class="container-fluid">

                    <button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                        <span>Campus Buddy</span>
                    </button>
                    <button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <i class="fas fa-align-justify"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="nav navbar-nav ml-auto">
                            
                            
                            <li class="nav-item">
                                <a class="nav-link" href="#">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
         
<h3>See Student Gatepass Status</h3>

<div>
  <form method="POST" action="ModifyStudent">
    <label for="fname">Enter UID</label>
    <input type="text2" id="uid" name="UID" placeholder="Student UID">
    <input type="submit2" value="Fetch" onclick="fetchdata('GATEPASS')">
    <br/>
    
    
    
     <label for="fname">Gatepass Id</label>
    <input type="text" id="gatepassid" name="gatepassid" placeholder="Gatepass ID">
    
    <label for="fname">Place of Visit</label>
    <input type="text" id="place" name="placeofvisit" placeholder="Place of visit">
    
    <label for="fname">Start Date</label>
    <input type="text" id="startdate" name="startdate" placeholder="Start date">
    
    <label for="fname">End Date</label>
    <input type="text" id="enddate" name="enddate" placeholder="End date">
    
     <label for="fname">Issued by</label>
    <input type="text" id="issuedby" name="issuedby" >
    
     <label for="fname">Issued date</label>
    <input type="text" id="issueddate" name="issueddate" >
    
     <label for="fname">Status</label>
    <input type="text" id="status" name="status">
  
    
    <input type="submit" value="Student Check Out">
  </form>
</div>
        </div>
    </div>
    


    <!-- jQuery CDN - Slim version (=without AJAX) -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <!-- Popper.JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js" integrity="sha384-cs/chFZiN24E4KMATLdqdvsezGxaGsi4hLGOzlXwp5UZB1LY//20VyM2taTB4QvJ" crossorigin="anonymous"></script>
    <!-- Bootstrap JS -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
    <!-- jQuery Custom Scroller CDN -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.concat.min.js"></script>

    <script type="text/javascript">
        $(document).ready(function () {
            $("#sidebar").mCustomScrollbar({
                theme: "minimal"
            });

            $('#sidebarCollapse').on('click', function () {
                $('#sidebar, #content').toggleClass('active');
                $('.collapse.in').toggleClass('in');
                $('a[aria-expanded=true]').attr('aria-expanded', 'false');
            });
        });
    </script>
    
    <script type="text/javascript "src="js/ScriptHandler.js" >
        </script>
    
    <script type="text/javascript">
        function fetchdata(data_type){
            //prompt("Hello");
              if(data_type == 'STUDENT'){
               var uid = document.getElementById('uid').value;
                var action = "GETSTUDENT";
                var fieldNames = "UID";
                var fieldValues = uid;
                var response = handlePost(action,fieldNames,fieldValues);
                if(response != null){
                    
                 processResponse(response);
                    
                }
                else{
                
                 alert("Failed to process request. Contact Admin");
                
                }
                
            }
            
            else if(data_type=='GATEPASS'){
                var uid = document.getElementById('uid').value;
                var action = "GETGATEPASS";
                var fieldNames = "UID";
                var fieldValues = uid;
                var response = handlePost(action,fieldNames,fieldValues);
                if(response != null){
                    
                 processResponse(response);
                    
                }
                else{
                
                 alert("Failed to process request. Contact Admin");
                
                }
            }
           
        }
        
        function processResponse(responseXML) {
            
            var parser, xmlDoc;
            parser = new DOMParser();
            xmlDoc = parser.parseFromString(responseXML,"text/xml");
            
            var status = xmlDoc.getElementsByTagName("STATUS")[0].childNodes[0].nodeValue;
            var message = xmlDoc.getElementsByTagName("MESSAGE")[0].childNodes[0].nodeValue;
            
            if (status == "FAILURE") {
                
                document.getElementById("uid").value = "";
                document.getElementById("gatepassid").value = "";
                document.getElementById("place").value = "";
                document.getElementById("startdate").value = "";
                document.getElementById("enddate").value = "";                
                document.getElementById("issuedby").value = "";
                document.getElementById("issuedate").value = "";
                document.getElementById("status").value = "";
                
                alert(message);
                return false;
            }
            else if (status == "SUCCESS") {
                
                
                document.getElementById("gatepassid").value = xmlDoc.getElementsByTagName("GATEPASSID")[0].childNodes[0].nodeValue;
                document.getElementById("place").value = xmlDoc.getElementsByTagName("PLACE")[0].childNodes[0].nodeValue;
                document.getElementById("startdate").value = xmlDoc.getElementsByTagName("STARTDATE")[0].childNodes[0].nodeValue;
                document.getElementById("enddate").value = xmlDoc.getElementsByTagName("ENDDATE")[0].childNodes[0].nodeValue;
                document.getElementById("issuedby").value = xmlDoc.getElementsByTagName("ISSUEDBY")[0].childNodes[0].nodeValue;                
                document.getElementById("issuedate").value = xmlDoc.getElementsByTagName("ISSUEDDATE")[0].childNodes[0].nodeValue;
                document.getElementById("status").value = xmlDoc.getElementsByTagName("STATUS")[0].childNodes[0].nodeValue;
                //document.getElementById("uid").readonly = true;
            }
            
        }
        /*
        var request;  
        function handlePost(actionId, fieldNames, fieldValues){
            debugger;
            var response = null;
            
            if(window.XMLHttpRequest){  
                request=new XMLHttpRequest();  
            }  
            else if(window.ActiveXObject){  
                request=new ActiveXObject("Microsoft.XMLHTTP");  
            }  

            var url = "RequestProcessor?" + 'actionId=' + actionId + '&fieldNames=' + fieldNames + '&fieldValues=' + fieldValues;
            try {  
            request.onreadystatechange=getInfo;  
            request.open("GET","test.jsp",false);  
            request.send();  
            }catch(e){
                alert("Unable to connect to server");              
            }                 
        }
                
        function getInfo(){  
            if(request.readyState==4){  
              var val = request.responseText;               
            }  
        }       
           
        */
        
        
        </script>
        
</body>

</html>