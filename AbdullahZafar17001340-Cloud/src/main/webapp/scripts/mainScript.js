$(document).ready(function() 
{
	showAllFilms();
    
    $("#insertButton").click(insertFilm);
    $("#updateButton").click(updateFilm);
    $("#searchButton").click(searchFilm);
    $("#confirmDelete").click(deleteFilm);
    $("#allFilmsJson").click(showAllFilms);
 
    
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
			format: $("#format").val()
	};
	
	$.ajax({url: "getFilm?",data: fieldValue, datatype: fieldValue.format, success: function(text) { insertText(text, resultRegion2) } });
	
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
	
	var Format={
			format: "json"
	}
	
	
	
	$.ajax({url: "ControllerServlet?", data: format, success: function(data) 
		{ 
		if(Format.format == "json") { printAllJson(data, resultRegion9, format.format)
		}}, datatype: format.format});


}

function printAllJson(data, resultRegion)
{
	
	$("#tbAllJson").empty();
	
	var tr;
    for (var i = 0; i < data.length; i++) {
        tr = $('<tr/>');
        tr.append("<td>" + data[i].FilmID + "</td>");
        tr.append("<td>" + data[i].FilmName + "</td>");
        tr.append("<td>" + data[i].FilmYear + "</td>");
        tr.append("<td>" + data[i].FilmCredits + "</td>");
        tr.append("<td>" + data[i].FilmDuration + "</td>");
        tr.append("<td>" + data[i].FilmReview + "</td></table>");
        $('#tableAllJson').append(tr);
       
      
        
    }
    
   // document.getElementById("display").innerHTML = "Json";
    
	
}




