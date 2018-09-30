$(document).ready(
		function(){
					$('#su').click(function(){
						$.getJSON('ClientSignUpSubmit',{ajax:true,fname:$('#fname').val(),lname:$('#lname').val(),dob:$('#dob').val(),gender:$('#gender').val(),add:$('#add').val(),city:$('#city').val(),state:$('#state').val(),mobile:$('#mobile').val(),email:$('#email').val(),pwd:$('#pwd').val(),cpwd:$('#cpwd').val()},function(data){
						alert('Submit');
							$('#res').html(data.result);
							if(data.result=='Record Submitted...')
							{	$('#uid').val($('#email').val()); 	}
						});
					});	 
	 

$('#login').click(function(){
	
				$.getJSON('ClientLoginCheckForJS',{ajax:true,uid:$('#uid').val(),pwd:$('#clpwd').val()},function(data){
 
					if(data.res=='1')
					{	window.location.href='ClientHome';	}
					else
					{
						$('#lmsg').html('<font color=red><b><i>Invalid Emailid/Mobileno/Password...</i></b></font>');
					}
				});
			});	 
 });