//Nitin Kaveriappa Udiyanda Muthanna G01000006
function usrGreet() {
  var name = getCookie("username");
  var greet = getGreeting();
  if(name != "") {
    alert("Welcome!!! "+greet+" "+name);
  }
  else {
    user = prompt("Please enter your name:","");
    if (user != "" && user != null) {
      setCookie("username", user, 365);
      alert(greet+" "+user+", Welcome to Assignment#3!!!");
    }
    else {
      alert("Please enter your name");
    }
  }

}

function callRenewSet() {
  user = prompt("Please enter your name:","");
  if (user != "" && user != null) {
    setCookie("username", user, 365);
    location.reload();
  }
  else {
    alert("Please enter your name");
  }
}

function getGreeting() {
  var greet;
  var date = new Date();
  var hr = date.getHours();
  if(hr < 12) {
    greet = "Good Morning";
  }
  else {
    hour = hr - 12;
    if(hour < 6) {
      greet = "Good Afternoon";
    }
    else {
      greet = "Good Evening";
    }
  }
  return greet;
}

function setCookie(cname, cvalue, exdays) {
    var d = new Date();
    d.setTime(d.getTime() + (exdays * 24 * 60 * 60 * 1000));
    var expires = "expires="+d.toUTCString();
    document.cookie = cname + "=" + cvalue + ";" + expires + ";";
}

function getCookie(cname) {
    var name = cname + "=";
    var ca = document.cookie.split(';');
    for(var i = 0; i < ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}


function calAvgMax(values) {
  var val = values.split(',');
  if(val.length == 10) {
    var max = Math.max(...val);
    var avg=0;
    for(var i=0;i<val.length;i++)
  	{
  		avg +=  parseInt(val[i],10);
  	}
  	avg = avg/10;
  	document.getElementById('avg').innerHTML = avg;
  	document.getElementById('max').innerHTML = max;

    for(var i=0;i<10;i++) {
     if(val[i] < 0 || val[i] > 100) {
       document.getElementById('avg').innerHTML = "";
     	 document.getElementById('max').innerHTML = "";
        alert("Please Enter Data in the form of numbers between 0 and 100");
      }
    }
  }
  else {
    document.getElementById('avg').innerHTML = "";
    document.getElementById('max').innerHTML = "";
    alert("Please Enter only 10 numbers");
  }
}

function formValidate() {
  var name = document.getElementsByName("name")[0].value;
  var streetaddress = document.getElementsByName("streetaddress")[0].value;
  var checkbox = document.getElementsByName("like");
  var radio = document.getElementsByName("interest");
  var email = document.getElementsByName("email")[0].value;
  var zip =document.getElementsByName('zip')[0].value;
  var errmsg = '';

  if(!(/^[A-z ]*$/.test(name)))
  {
    errmsg += "Name should contain only alphabets;\n"
    document.getElementsByName("name")[0].value = "";
  }
  if(!(/^[A-z0-9 ]*$/.test(streetaddress)))
	{
		errmsg += "Street Addres should contain only alphabets and numbers;\n";
		document.getElementsByName("streetaddress")[0].value = "";
	}
	if(!(/^[A-z0-9._%+-]+@[A-z0-9.-]+\.[A-z]{1,4}$/.test(email)))
	{
		errmsg += "Entered email is not of valid format;\n";
		document.getElementsByName("email")[0].value = "";
	}
  if(!(/^[0-9]{1,6}$/.test(zip)))
	{
		errmsg += "Zipcode should contain only Numbers; ";
		document.getElementsByName("zip")[0].value = "";
	}

	var checkedLike=0;
	for(var i =0;i<checkbox.length;i++)
	{
		if(checkbox[i].checked)
		{
			checkedLike++;
		}
	}
	if(checkedLike < 2)
	{
		errmsg += "Select atleast 2 things that you liked about GMU;\n";
	}

	var radioInterest = false;
	for(var i =0;i<radio.length;i++)
	{
		if(radio[i].checked)
		{
			radioInterest = true;
		}
	}
	if(!radioInterest)
	{
		errmsg += "Select the how did you become interested in GMU;\n";
	}

  if(errmsg.length>1)
  {
    $(".err").text(errmsg);
		$(".err").dialog({modal:true});
    return false;
  }

  return true;
}

function checkZip(zipCode)
{
	$.ajax({
			url:'zipcodes.json',
			type:'POST',
			dataType:'json',
			success: function(response){
        for(var i=0;i<4;i++) {
          if(parseInt(zipCode,10) == parseInt(response.zipcodes[i].zip,10)) {
            document.getElementById('city').value = response.zipcodes[i].city;
						document.getElementById('state').value = response.zipcodes[i].state;
          }
				}
			},
      error: function(data){alert(data.responseText);}
	});
}
