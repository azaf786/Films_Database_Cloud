$(document).ready(function() 
{
	showAllFilms();
	//changes the h2 value to text when the page loaded
	document.getElementById("type").innerHTML = "Films TEXT";
	//button onlick listener that trigger different function
    $("#insertButton").click(insertFilm);
    $("#updateButton").click(updateFilm);
    $("#searchButton").click(searchFilm);
    $("#confirmDelete").click(deleteFilm);
    $("#allFilmsJson").click(showAllJsonFilms);
    $("#allFilmsXml").click(showAllXmlFilms);
    $("#allFilmsText").click(showAllTextFilms);
    $("#AttributeSearchButton").click(searchUsingAttribute);
    //followings are divs that contain different resu
    $("#allJsonFilms").hide();
	$("#allXmlFilms").hide();
	$("#showAllFilms").show();
	$("#JsonFilmDiv").hide();
	$("#XmlFilmDiv").hide();
 
    
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
    	
    	$("#attributeSearchDialog").dialog({
    		autoOpen: false
    		});

    	$("#Dialogsearch").on("click", function() {
    		$("#searchDialog").dialog("open");
    		$("#deleteDialog").dialog("close");
    		$("#updateDialog").dialog("close");
    		$("#insertDialog").dialog("close");
    		$("#attributeSearchDialog").dialog("close");
    	});
    	
    	$("#DialogsearchAttribute").on("click", function() {
    	$("#attributeSearchDialog").dialog("open");
    	$("#searchDialog").dialog("close");
    	$("#deleteDialog").dialog("close");
    	$("#updateDialog").dialog("close");
    	$("#insertDialog").dialog("close");
    	});

    	$("#Dialogdelete").on("click", function() {
    		$("#deleteDialog").dialog("open");
    		$("#searchDialog").dialog("close");
    		$("#updateDialog").dialog("close");
    		$("#insertDialog").dialog("close");
    		$("#attributeSearchDialog").dialog("close");
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
    		$("#attributeSearchDialog").dialog("close");
    		});

    	$("#Dialogupdate").on("click", function() {
    		$("#updateDialog").dialog("open");
    		$("#deleteDialog").dialog("close");
    		$("#insertDialog").dialog("close");
    		$("#searchDialog").dialog("close");
    		$("#attributeSearchDialog").dialog("close");
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

	$.ajax({url: "getFilm", data: fieldValue,success: function(text) { if(fieldValue.type == "json") { printJson(text, resultRegion2)
	}	else if (fieldValue.type == "text") { insertText(text, resultRegion2);}
		else if(fieldValue.type == "xml") { printXml(text, resultRegion2)}}, datatype: fieldValue.type});
	
	
	document.getElementById('searchField').value ="";
	$("#searchDialog").dialog("close");
	
	$("#JsonFilmDiv").hide();
	$("#resultRegion").show();
	$("#XmlFilmDiv").hide();
}

function searchUsingAttribute()
{
	var resultRegion = "#resultRegion";
	
	var data = 
	{
		attributeToSearch: $("#AttributeToSearch").val(),
		informationEntered: $("#InfoToSearch").val(),
		type: $("#format").val()
	};
	
	$.ajax({url: "getFilmAttribute", data: data,success: function(text) { if(data.type == "json") { printJson(text, resultRegion)
	}	else if (data.type == "text") { insertText(text, resultRegion);}
		else if(data.type == "xml") { printXml(text, resultRegion)}}, datatype: data.type});
}

function deleteFilm()
{
	var resultRegion3 = "#resultRegion";
	var fieldValue= 
	{
			filmId: $("#deleteField").val(),
			type: $("#format").val()
	}
	$.ajax({url: "deleteFilm", data: fieldValue,success: function(text) { if(fieldValue.type == "json") { printJson(text, resultRegion3)
	}	else if (fieldValue.type == "text") { insertText(text, resultRegion3);}
		else if(fieldValue.type == "xml") { printXml(text, resultRegion3)}}, datatype: fieldValue.type});
	
	var e;
	for(e = 0; e<2;e++)
	{
		showAllFilms();
	}
	 document.getElementById('deleteField').value ="";
	 $("#deleteDialog").dialog("close");
	 
	 $("#JsonFilmDiv").hide();
		$("#resultRegion").show();
		$("#XmlFilmDiv").hide();
	
	
}

function insertFilm()
{
	var resultRegion4 = "#resultRegion";
	var fieldValue = {
	
	filmName: $("#insertFilmName").val(),
	filmYear: $("#insertFilmYear").val(),
	filmCredits: $("#insertFilmCredits").val(),
	filmDuration: $("#insertFilmDuration").val(),
	filmReview: $("#insertFilmReview").val(),
	type: $("#format").val()
	}
	
	$.ajax({url: "insertFilm", data: fieldValue,success: function(text) { if(fieldValue.type == "json") { printJson2(text, resultRegion4)
	}	else if (fieldValue.type == "text") { insertText(text, resultRegion4);}
		else if(fieldValue.type == "xml") { printXml(text, resultRegion4)}}, datatype: fieldValue.type});
	

	
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
	
	$("#JsonFilmDiv").hide();
	$("#resultRegion").show();
	$("#XmlFilmDiv").hide();
	
	
}


function updateFilm()
{
	var resultRegion5 = "#resultRegion";
	var fieldValue = {
	
	filmId: $("#updateFilmId").val(),
	filmName: $("#updateFilmName").val(),
	filmYear: $("#updateFilmYear").val(),
	filmCredits: $("#updateFilmCredits").val(),
	filmDuration: $("#updateFilmDuration").val(),
	filmReview: $("#updateFilmReview").val(),
	type: $("#format").val()
	}
	
	$.ajax({url: "updateServlet", data: fieldValue,success: function(text) { if(fieldValue.type == "json") { printJson2(text, resultRegion5)
	}	else if (fieldValue.type == "text") { insertText(text, resultRegion5);}
		else if(fieldValue.type == "xml") { printXml(text, resultRegion5)}}, datatype: fieldValue.type});
	

	
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
	
	$("#JsonFilmDiv").hide();
	$("#resultRegion").show();
	$("#XmlFilmDiv").hide();
	
	
	
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

function showAllXmlFilms()
{
	var resultRegion9 = "#allJsonFilms";
	var type =
		{
			type: "xml"
		}
	
	$.ajax({url: "ControllerServlet?", data: type, success: function(text) { printAllXml(text, resultRegion9) }, dataType: type.type});
	
	
}

function showAllTextFilms()
{
	
	$("#allJsonFilms").hide();
	$("#allXmlFilms").hide();
	$("#showAllFilms").show();
	showAllFilms();
	document.getElementById("type").innerHTML = "Films TEXT";
}





function printAllJson(data, resultRegion)
{
	$("#tbAllJson").empty();
	$("#allJsonFilms").show();
	$("#allXmlFilms").hide();
	$("#showAllFilms").hide();
	document.getElementById("type").innerHTML = "Films JSON";
	
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


function printJson(data, resultRegion)
{
	$("#tbJson").empty();
	$("#JsonFilmDiv").show();
	$("#resultRegion").hide();
	$("#XmlFilmDiv").hide();
	
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

function printJson2(data, resultRegion)
{
	$("#JsonFilmDiv").show();
	$("#resultRegion").hide();
	$("#XmlFilmDiv").hide();
	
	console.log(data);
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

function getElementValues(element, subElementNames) {
	  var values = new Array(subElementNames.length);
	  for(var i=0; i<subElementNames.length; i++) {
	    var name = subElementNames[i];
	    var subElement = element.getElementsByTagName(name)[0];
	    values[i] = getBodyContent(subElement);
	  }
	  return(values);
	}

//Given an element, returns the body content.

function getBodyContent(element) {
  element.normalize();
  return(element.childNodes[0].nodeValue);
}

function printAllXml(text, resultRegion)
{
	
	document.getElementById("type").innerHTML = "Films XML";
	
	$("#tbAllXml").empty();
	$("#allJsonFilms").hide();
	$("#allXmlFilms").show();
	$("#showAllFilms").hide();
	
	var films = text.getElementsByTagName("film");
	
	var rows = new Array();
	for(var i=0; i<films.length; i++) 
	{
		var film = films[i];
		var subElements = ["filmID", "filmName", "filmYear", "filmCredits", "filmDuration", "filmReview"];
		rows[i] = getElementValues(film, subElements);
		
		console.log(rows[i]);
		console.log(rows[i].length);
		
		var tr;
		tr = $('<tr/>');
		for(var b=0; b < rows[i].length; b++)
		{
			console.log(rows[i][b]);
			tr.append("<td>" + rows[i][b] + "</td>");
			$('#tableAllXml').append(tr);
		}
	}
}


function printXml(text, resultRegion)
{
	
	$("#tbXml").empty();
	$("#JsonFilmDiv").hide();
	$("#resultRegion").hide();
	$("#XmlFilmDiv").show();
	
	var films = text.getElementsByTagName("film");
	
	var rows = new Array();
    for(var i=0; i<films.length; i++) 
    {
      var film = films[i];
      var subElements = ["filmID", "filmName", "filmYear", "filmCredits", "filmDuration", "filmReview"];
      rows[i] = getElementValues(film, subElements);
      
      console.log(rows[i]);
      console.log(rows[i].length);
      
      var tr;
      tr = $('<tr/>');
      for(var b=0; b < rows[i].length; b++)
	  {
    	  console.log(rows[i][b]);
        tr.append("<td>" + rows[i][b] + "</td>");
        $('#xmlTable').append(tr);
	  }
    }
}



