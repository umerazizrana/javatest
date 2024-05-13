<!DOCTYPE html>

<html>

<head>
<title>Data Input Form</title>
<link rel="stylesheet" href="css/input.css"/>
<meta content="UTF-8">

<script type="text/javascript">

	function validateInput(){
		resetAll();
		var errMsg = "";
		var age = document.getElementById("age").value;
		var regex=/^[0-9]+(.[0-9]+)?$/;
		if(!regex.test(age) || age == 0){
			document.getElementById("age").className = "error";
			errMsg += "Input a valid age.<br>";
		}
		
		var hB = document.getElementById("hb").value;
		var regex=/^[0-9]+(.[0-9]+)?$/;
		if(!regex.test(hB) || hB == 0){
			document.getElementById("hb").className = "error";
			errMsg += "Input a valid Hb value.<br>";
			
		}
		
		if(document.getElementById("vFile1").value == ""){
			document.getElementById("vFile1").className = "error";
			errMsg += "Please select a video file for Samsung.<br>";
		}
		
		if(document.getElementById("vFile2").value == ""){
			document.getElementById("vFile2").className = "error";
			errMsg += "Please select a video file for Redmi.<br>";
		}
		document.getElementById("errMsg").innerHTML = errMsg;
		
		if(errMsg == ''){
			document.forms.dataFrorm.submit();
		}
	}
	
	function resetAll(){
		document.getElementById("errMsg").innerHTML = "";
		document.getElementById("age").className = "";
		document.getElementById("hb").className = "";
		document.getElementById("vFile1").className = "";
		document.getElementById("vFile2").className = "";
	}

</script>

</head>

<body>
<h2>Input Patient Data</h2>
<form name="dataFrom" id="dataFrorm" method='POST' action="CollectData" enctype="multipart/form-data">
<table class="tset">
<tr><td colspan="2"><div id="errMsg"></div></td></tr>
<tr><td>Id:</td><td><input type="text" name="id"/></td></tr>
<tr><td>Age:</td><td><input type="text" name="age" id="age"></td></tr>
<tr><td>Gender:</td><td>
	<select name='gender' id='gender'>
		<option value="0">Male</option>
		<option value="1">Female</option>				
	</select>
</td></tr>
<tr><td>Blood Group:</td><td>
	<select name='bGroup' id='bGroup'>
		<option value="NA">Not Known</option>
		<option value="A+">A+</option>
		<option value="B+">B+</option>
		<option value="AB+">AB+</option>
		<option value="O+">O+</option>
		<option value="A-">A+</option>
		<option value="B-">B+</option>
		<option value="AB-">AB+</option>
		<option value="O-">O+</option>				
	</select>
</td></tr>
<tr><td>Is Pregnant:</td><td>
	<label class="switch">
  		<input type="checkbox" name="preg">
  			<span class="slider round"></span>
	</label>
</td></tr>
<tr><td>Hb:</td><td><input type="text" name="hb" id='hb'></td></tr>
<tr><td>Video File (Samsung):</td><td><input id="vFile1" type="file" name="vFile1" accept="video/*"></td></tr>
<tr><td>Video File (Redmi):</td><td><input id="vFile2" type="file" name="vFile2" accept="video/*"></td></tr>
<tr><td>Any known conditions:</td>
	<td><textarea id="misc" name="misc" rows="4" cols="50"></textarea></td>
</tr>
<tr><td>&nbsp;</td><td style="float:right; padding:0px"><input type="button" name="sbBtn" onclick="validateInput()" value="Save"></td></tr>
</table>

</form>
</body>
</html>