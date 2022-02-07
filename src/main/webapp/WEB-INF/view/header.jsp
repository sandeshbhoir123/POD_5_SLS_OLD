<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!-- up navigation bar -->
        <header>
            <h1 style="font-size: xx-large;">Admin's Dashboard</h1>
            <nav>
                <ul class="nav__links">
                    <li><a href="<c:url value="/dashbord"/>">Home</a></li>
                    <li><a href="<c:url value="/welcome"/>">Services</a></li>
                    <li><a href="<c:url value="/welcome"/>">About</a></li>
                </ul>
            </nav>
           <a href="<c:url value="/login"/>"><button>Logout</button></a>
        </header>

        <div class="admin-wrapper">
            <!----left side bar-->
            <div class="left-sidebar">

            </div>
            <!----admin content-->
            <div class="admin-content">

            </div>

        </div>
            <!-- Side navigation -->
            <div class="sidenav">
                <div>
                    <img src="/The-School-Directory/resources/Images/avatar-user-student-3e3e52aa56aeb627-512x512.png" id="icon" alt="User Icon" />
                </div>

                <div class="admin-bio">
                    <h2>Welcome Admin</h2>
                </div>
        
                <a href="<c:url value="/school"/>"><button>Add Schools</button></a>
                <a href="<c:url value="/suggestion/search"/>"><button>Suggestions</button></a>
            </div>