$(document).ready(function() {
$(function() {
$("#dialog1").dialog({
autoOpen: false
});

$("#dialog2").dialog({
	autoOpen: false
	});

$("#dialog3").dialog({
	autoOpen: false
	});

$("#dialog4").dialog({
	autoOpen: false
	});

$("#dialog2Confirm").dialog({
	autoOpen: false
	});

$("#Dsearch").on("click", function() {
$("#dialog1").dialog("open");
$("#dialog2").dialog("close");
$("#dialog3").dialog("close");
$("#dialog4").dialog("close");
});

$("#Ddelete").on("click", function() {
	$("#dialog2").dialog("open");
	$("#dialog1").dialog("close");
	$("#dialog3").dialog("close");
	$("#dialog4").dialog("close");
	});

$("#deleteButtonConfirm").on("click", function() {
	$("#dialog2Confirm").dialog("open");

	});

$("#closeDeleteButton").on("click", function() {
	$("#dialog2Confirm").dialog("close");
	});

$("#deleteButton").on("click", function() {
	$("#dialog2Confirm").dialog("close");
	});


$("#Dinsert").on("click", function() {
	$("#dialog3").dialog("open");
	$("#dialog1").dialog("close");
	$("#dialog2").dialog("close");
	$("#dialog4").dialog("close");
	});

$("#Dupdate").on("click", function() {
	$("#dialog4").dialog("open");
	$("#dialog3").dialog("close");
	$("#dialog2").dialog("close");
	$("#dialog1").dialog("close");
	});

});
// Validating Form Fields.....
$("#submit").click(function(e) {
var email = $("#email").val();
var name = $("#name").val();
var emailReg = /^([w-.]+@([w-]+.)+[w-]{2,4})?$/;
if (email === '' || name === '') {
alert("Please fill all fields...!!!!!!");
e.preventDefault();
} else if (!(email).match(emailReg)) {
alert("Invalid Email...!!!!!!");
e.preventDefault();
} else {
alert("Form Submitted Successfully......");
}
});
});