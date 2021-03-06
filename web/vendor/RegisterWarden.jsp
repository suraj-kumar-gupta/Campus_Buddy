<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>Admin Dashboard</title>

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

input[type=password], select {
    width: 100%;
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
                <li >
                    <a href="#homeSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Warden</a>
                    <ul class="collapse list-unstyled" id="homeSubmenu">
                        <li class="active">
                            <a href="RegisterWarden.jsp">Register Warden</a>
                        </li>
                        <li>
                            <a href="ModifyWarden.jsp">Modify Warden</a>
                        </li>
                        <li>
                            <a href="DeleteWarden.jsp">Delete Warden</a>
                        </li>
                    </ul>
                </li>
                
                <li>
                    <a href="#pageSubmenu" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle">Security</a>
                    <ul class="collapse list-unstyled" id="pageSubmenu">
                        <li>
                            <a href="RegisterSecurity.jsp">Add Security</a>
                        </li>
                        <li>
                            <a href="ModifySecurity.jsp">Modify Security</a>
                        </li>
                        
                        <li>
                            <a href="DeleteSecurity.jsp">Delete Security</a>
                        </li>
           
                    </ul>
                </li>
                <li>
                    <a href="#">Appointed Wardens</a>
                </li>
                <li>
                    <a href="#">Appointed Security</a>
                </li>
                <li>
                    <a href="AdminLogout">Logout</a>
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
                                <a class="nav-link" href="WardenDashboard.jsp">Home</a>
                            </li>
                            
                            <li class="nav-item">
                                <a class="nav-link" href="#">Profile</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="AdminLogout">Logout</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>

            <div class="line"></div>
            
            
<h3>Enter warden details</h3>

<div>
  <form method="POST" action="RegisterWarden">
    <label for="fname">Enter Warden UID</label>
    <input type="text" id="uid" name="UID" placeholder="Warden UID">

    <label for="fname">Full name</label>
    <input type="text" id="fname" name="fullname" placeholder="Warden's Name">

    
    <label for="fname">Contact number</label>
    <input type="text" id="studentno" name="usrtel" placeholder="Contact number">
    
    <label for="fname">Email id</label>
    <input type="text" id="parent" name="email" placeholder="email">
    
    <label for="fname">Password</label>
    <input type="password" id="password" name="password" placeholder="Password">
    
    <label for="Hostel">Hostel</label>
    <select id="Hostel" name="hostel">
      <option value="Nek Chand Tower 1">NC - 1</option>
      <option value="Nek Chand Tower 2">NC - 2</option>
      <option value="Nek Chand Tower 3">NC - 3</option>
      <option value="Nek Chand Tower 4">NC - 4</option>
      <option value="Nek Chand Tower 5">NC - 5</option>
      <option value="Nek Chand Tower 6">NC - 6</option>
      <option value="Zakir - A">Zakir A</option>
      <option value="Zakir - B">Zakir B</option>
      <option value="LC - A">LC - A</option>
      <option value="LC - B">LC - B</option>
      <option value="LC - C">LC - C</option>
      <option value="LC - D">LC - D</option>
      <option value="Sukhna Girls A">Sukhna - A</option>
      <option value="Sukhna Girls B">Sukhna - B</option>
      <option value="Tagore Girls Hostel">Tagore</option>
      
    </select>
  
    <input type="submit" value="Register Warden">
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
        
       
}
    </script>
</body>

</html>