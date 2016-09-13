<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="../../shared/Bootstraplink.jsp"%>

<html >
    <head>
        <title>Main Panel</title>
        
    </head>

    <body>
        <table width="100%" border="0" style="border:1px solid gray;">
            <tr>
                <td width="5%" valign="top">
                    <table width="100%" >
                        </table>
                    <!-- left navigation-->
                    <c:import url="sidebar.jsp"/>
                </td>
                <td width="80%"  valign="top"  style="height:700px;">
                    <table width="100%" border="0" >
                        <tr>
                            <td style="font-size: 18px; font-weight: bold; text-align: center; border-bottom: 1px solid gray;background:#00CC99">Student Content Collection </td>
                        </tr>
                        <tr>
                            <td>
                               <p>
                                <br>
                                <c:if test="${retValue == 'user'}">
                                    <c:import url="User_Entry.jsp"/>
                                </c:if>
                                <c:if test="${retValue == 'viewuser'}">
                                    <c:import url="viewUsers.jsp"/>
                                </c:if>
                                  <c:if test="${retValue == 'faculty'}">
                                    <c:import url="Faculty_Entry.jsp"/>
                                </c:if>
                                <c:if test="${retValue == 'viewfaculty'}">
                                    <c:import url="Faculty_View.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'programme'}">
                                    <c:import url="Program_Entry.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'viewprogramme'}">
                                    <c:import url="Program_View.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'subject'}">
                                    <c:import url="Subject_Entry.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'viewsubject'}">
                                    <c:import url="Subject_View.jsp"/>
                                </c:if>
                                
                                 <c:if test="${retValue == 'e-books'}">
                                    <c:import url="EBook_Entry.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'viewe-books'}">
                                    <c:import url="EBook_View.jsp"/>
                                </c:if>
                                
                                 <c:if test="${retValue == 'modal'}">
                                    <c:import url="Modal_Entry.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'viewmodal'}">
                                    <c:import url="Modal_View.jsp"/>
                                </c:if>
                                 <c:if test="${retValue == 'editfaculty'}">
                                    <c:import url="Faculty_Edit.jsp"/>
                                 </c:if>
                                <c:if test="${retValue == 'editprogramme'}">
                                    <c:import url="Program_Edit.jsp"/>
                                 </c:if>
                                
                                 <c:if test="${retValue == 'editsubject'}">
                                    <c:import url="Subject_Edit.jsp"/>
                                 </c:if>
                                
                                 <c:if test="${retValue == 'edituser'}">
                                    <c:import url="User_Edit.jsp"/>
                                 </c:if>
                                
                                 <c:if test="${retValue == 'editbook'}">
                                    <c:import url="EBook_Edit.jsp"/>
                                 </c:if>
                                
                                <c:if test="${retValue == 'editmodal'}">
                                    <c:import url="Modal_Edit.jsp"/>
                                 </c:if>
                                
                                
                                
                                
                                </p>
                               
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>
        </table>


    </body>
</html>