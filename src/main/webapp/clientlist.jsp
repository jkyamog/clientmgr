<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>Clients</title>
<link rel="stylesheet" type="text/css" href="${pageContext['request'].contextPath}/css/style.css" />
<link type="text/css" href="${pageContext['request'].contextPath}/css/smoothness/jquery-ui-1.8.8.custom.css" rel="Stylesheet" />   
<link type="text/css" href="${pageContext['request'].contextPath}/css/table.css" rel="Stylesheet" />   
<script type="text/javascript" src="${pageContext['request'].contextPath}/js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="${pageContext['request'].contextPath}/js/jquery.dataTables.min.js"></script>
<script>
$(document).ready(function() {
    $('#clients').dataTable( {
       "sAjaxSource": '${pageContext['request'].contextPath}/rest/client/testscala',
       "aoColumns": [ 
            null,
            null
       ],
       "aaSorting": [[ 1, "asc" ]],
       "sPaginationType": "full_numbers",
       "fnRowCallback": function( nRow, aData, iDisplayIndex, iDisplayIndexFull ) {
    	    $('td:eq(0)', nRow).html( 
                    '<a href="${pageContext['request'].contextPath}/client/' + aData[0] + '/form"><img title="edit" src="${pageContext['request'].contextPath}/images/gtk-edit.png"></a>' +
    	    		' <a href="${pageContext['request'].contextPath}/client/' + aData[0] + '">' + aData[0] + '</a>'
    	    		);
    	    return nRow;
       }
    } );
    
    
} );
</script>
</head>
<body>
<div class="main">

<div class="content">
<div class="content_resize">
  <p> <a href="client/form"><img title="add" src="${pageContext['request'].contextPath}/images/list-add.png"> Add Client </a></p>

<table id="clients" class="display">
  <thead>
  <tr>
    <th>First Name</th>
    <th>Last Name</th>
  </tr>
  </thead>
  <tbody>
    <tr>
      <td>
        first name
      </td>
      <td>
        last name
      </td>
    </tr>
  </tbody>
</table>

</div>
</div>

</div>

</body>
</html>