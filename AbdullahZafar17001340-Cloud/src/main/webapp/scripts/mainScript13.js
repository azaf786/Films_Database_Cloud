$(document).ready(function() 
{
	showAllFilms();
    
    $("#insertButton").click(insertFilm);
    $("#updateButton").click(updateFilm);
    $("#searchButton").click(searchFilm);
    $("#confirmDelete").click(deleteFilm);
    $("#allFilmsJson").click(showAllJsonFilms);
 
    
    ////////////////////////////////////
    ////////////////////////////////////
    ///////Functions for Dialog/////////
    ////////////////////////////////////
    ///////////////////////////////////
    
    
    $(function() {
    	$("#searchDialog").dialog({
    	autoOpen: false
    	});

    	$("#deleteDialog").dialog({
    		autoOpen: false
    		});

    	$("#insertDialog").dialog({
    		autoOpen: false
    		});

    	$("#updateDialog").dialog({
    		autoOpen: false
    		});

    	$("#deleteDialogConfirm").dialog({
    		autoOpen: false
    		});

    	$("#Dialogsearch").on("click", function() {
    	$("#searchDialog").dialog("open");
    	$("#deleteDialog").dialog("close");
    	$("#updateDialog").dialog("close");
    	$("#insertDialog").dialog("close");
    	});

    	$("#Dialogdelete").on("click", function() {
    		$("#deleteDialog").dialog("open");
    		$("#searchDialog").dialog("close");
    		$("#updateDialog").dialog("close");
    		$("#insertDialog").dialog("close");
    		});

    	$("#deleteButton").on("click", function() {
    		if(document.getElementById('deleteField').value ==""){
    			
    		}
    		else{
    		$("#deleteDialogConfirm").dialog("open");
    		}

    		});

    	$("#cancelDelete").on("click", function() {
    		$("#deleteDialogConfirm").dialog("close");
    		});

    	$("#confirmDelete").on("click", function() {
    		$("#deleteDialogConfirm").dialog("close");
    		});


    	$("#Dialoginsert").on("click", function() {
    		$("#insertDialog").dialog("open");
    		$("#updateDialog").dialog("close");
    		$("#deleteDialog").dialog("close");
    		$("#searchDialog").dialog("close");
    		});

    	$("#Dialogupdate").on("click", function() {
    		$("#updateDialog").dialog("open");
    		$("#deleteDialog").dialog("close");
    		$("#insertDialog").dialog("close");
    		$("#searchDialog").dialog("close");
    		});

    	});
});
/////////////////////////////End of document ready and dialog//////////////////////////////////



function insertText(text, resultRegion) 
{
	  $(resultRegion).html(text);
}



function searchFilm()
{
	
	var resultRegion2 = "#resultRegion";
	var fieldValue={
			filmName: $("#searchField").val(),
			type: $("#format").val()
	};
	console.log(fieldValue);
	
//	$.ajax({url: "getFilm?",data: fieldValue, datatype: fieldValue.format, success: function(text) { insertText(text, resultRegion2) } });
	//$.ajax({url: "getFilm?",data: fieldValue, datatype: fieldValue.type, success: function(text) { if(fieldValue.type == "json") { printJson(text, resultRegion2)} else if(fieldValue.type == "xml"){console.log(text)} else if(fieldValue == "text"){ insertText(text, resultRegion2)} } });
	
	$.ajax({url: "getFilm", data: fieldValue,success: function(text) { if(fieldValue.type == "json") { printAllawJson(text, resultRegion2)
	}	else if (fieldValue.type == "text") { insertText(text, resultRegion2);}
		else if(fieldValue.type == "xml") { console.log("xmlssss") }}, datatype: fieldValue.type});
	
	
	document.getElementById('searchField').value ="";
	$("#searchDialog").dialog("close");
}

function deleteFilm()
{
	var resultRegion3 = "#resultRegion";
	var fieldsValues= $("#deleteField").val();
	
	$.ajax({url: "deleteFilm?filmId="+fieldsValues, success: function(text) { insertText(text, resultRegion3) } });
	
	var e;
	for(e = 0; e<2;e++)
	{
		showAllFilms();
	}
	 document.getElementById('deleteField').value ="";
	 $("#deleteDialog").dialog("close");
	
	
}

function insertFilm()
{
	var resultRegion4 = "#resultRegion";
	var fields = {
	
	filmName: $("#insertFilmName").val(),
	filmYear: $("#insertFilmYear").val(),
	filmCredits: $("#insertFilmCredits").val(),
	filmDuration: $("#insertFilmDuration").val(),
	filmReview: $("#insertFilmReview").val()
	}
	
	$.ajax({url: "insertFilm?", data:fields, success: function(text) { insertText(text, resultRegion4) } });


	
	var i;
	for(i = 0; i<2;i++)
	{
		showAllFilms();
	}
	
	document.getElementById('insertFilmName').value ="";
	document.getElementById('insertFilmYear').value ="";
	document.getElementById('insertFilmCredits').value ="";
	document.getElementById('insertFilmDuration').value ="";
	document.getElementById('insertFilmReview').value ="";
	
	$("#insertDialog").dialog("close");
	
	
}


function updateFilm()
{
	var resultRegion5 = "#resultRegion";
	var fieldss = {
	
	filmId: $("#updateFilmId").val(),
	filmName: $("#updateFilmName").val(),
	filmYear: $("#updateFilmYear").val(),
	filmCredits: $("#updateFilmCredits").val(),
	filmDuration: $("#updateFilmDuration").val(),
	filmReview: $("#updateFilmReview").val()
	}
	
	$.ajax({url: "updateServlet?", data:fieldss, success: function(text) { insertText(text, resultRegion5) } });
	
	var o;
	for(o = 0; o<2;o++)
	{
		showAllFilms();
	}
	
	document.getElementById('updateFilmId').value ="";
	document.getElementById('updateFilmName').value ="";
	document.getElementById('updateFilmYear').value ="";
	document.getElementById('updateFilmCredits').value ="";
	document.getElementById('updateFilmDuration').value ="";
	document.getElementById('updateFilmReview').value ="";
	
	$("#updateDialog").dialog("close");
	
	
	
}

function showAllFilms()
{
	var resultRegion1 = "#showAllFilms";
	
	$.ajax({url: "ControllerServlet", success: function(text) { insertText(text, resultRegion1) } });
	
}


function showAllJsonFilms()
{
	var resultRegion9 = "#allJsonFilms";
	var type =
		{
			type: "json"
		}
	
	$.ajax({url: "ControllerServlet?", data: type, success: function(text) { printAllJson(text, resultRegion9) }, dataType: type.type});
	
	
}

function printJson(data, resultRegion)
{
	console.log(data);
	console.log(data.filmID);
	$("#tbJson").empty();
	
	var tr;
        tr = $('<tr/>');
        tr.append("<td>" + data.filmID + "</td>");
        tr.append("<td>" + data.filmName + "</td>");
        tr.append("<td>" + data.filmYear + "</td>");
        tr.append("<td>" + data.filmCredits + "</td>");
        tr.append("<td>" + data.filmDuration + "</td>");
        tr.append("<td>" + data.filmReview + "</td></table>");
        $('#jsonTable').append(tr);
}




function printAllJson(data, resultRegion)
{
	$("#tbAllJson").empty();
	
	var tr;
    for (var i = 0; i < data.length; i++) {
        tr = $('<tr/>');
        console.log(data[i]);
        tr.append("<td>" + data[i].filmID + "</td>");
        tr.append("<td>" + data[i].filmName + "</td>");
        tr.append("<td>" + data[i].filmYear + "</td>");
        tr.append("<td>" + data[i].filmCredits + "</td>");
        tr.append("<td>" + data[i].filmDuration + "</td>");
        tr.append("<td>" + data[i].filmReview + "</td></table>");
        $('#tableAllJson').append(tr);
    }
}


function printAllawJson(data, resultRegion)
{
	$("#tbJson").empty();
	
	var tr;
    for (var i = 0; i < data.length; i++) {
        tr = $('<tr/>');
        console.log(data[i]);
        tr.append("<td>" + data[i].filmID + "</td>");
        tr.append("<td>" + data[i].filmName + "</td>");
        tr.append("<td>" + data[i].filmYear + "</td>");
        tr.append("<td>" + data[i].filmCredits + "</td>");
        tr.append("<td>" + data[i].filmDuration + "</td>");
        tr.append("<td>" + data[i].filmReview + "</td></table>");
        $('#jsonTable').append(tr);
    }
}




