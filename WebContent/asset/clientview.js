function vdisplay() {
	
					$.getJSON('VehicleByCityJSON',{ajax:true,city:$('#city').val(),tp:$('#tp').val()},function(data){
						$htm='<link rel="stylesheet" href="bootstrap.min.css"><table class="table table-bordered" cellspacing=5>';  	//local variable $htm
						$c=1; 							//column = 1
						$.each(data,function(i,item){
							if($c==1)
							{ $htm+='<tr>'; }
				
							$htm+='<td>';
							$htm+='<table class="table table-bordered" cellspacing=10 cellpadding=7 >';
							$htm+='<tr>';
							$htm+="<td valign=top cellpadding=10><img class='img-thumbnail' src='vehiclepicture/"+item.PICTURE+"' width=150 height=150><br><br><br><input class='btnpic btn btn-danger btn-xs' type=Button   vid='"+item.VEHICLEID+"' value='View More'></td>";
							$htm+='<td valign=top width=275><table class="table table-bordered">';
							$htm+='<tr><td><b>Vehicle</b></td><td>&ensp;:&emsp;'+item.VEHICLENAME+'</td></tr>';
							$htm+='<tr><td><b>Model</b></td><td>&ensp;:&emsp;'+item.MODELYEAR+'</td></tr>';
							$htm+='<tr><td><b>Color</b></td><td>&ensp;:&emsp;'+item.VEHICLECOLOR+'</td></tr>';
							$htm+='<tr><td><b>Type</b></td><td>&ensp;:&emsp;'+item.VEHICLETYPE+'</td></tr>';
							$htm+="<tr><td><b>Capacity</b></td><td>&ensp;:&emsp;"+item.VEHICLECAPACITY+'</td></tr>';
							$htm+="<tr><td><b>Insurance</b></td><td>&ensp;:&emsp;"+item.INSURANCE+'</td></tr>';
							$htm+="<tr><td><b>AC Status</b></td><td>&ensp;:&emsp;"+item.AC+'</td></tr>';
							$htm+="<tr><td><b>Fuel Type</b></td><td>&ensp;:&emsp;"+item.FUELTYPE+'</td></tr></table><br>';
							$htm+="<input class='btc btn btn-info btn-xs' type=Button  vid='"+item.VEHICLEID+"' vn='"+item.VEHICLENAME+"' vmodel='"+item.MODELYEAR+"' vcolor='"+item.VEHICLECOLOR+"' vtype='"+item.VEHICLETYPE+"' vcapacity='"+item.VEHICLECAPACITY+"' vins='"+item.INSURANCE+"' vac='"+item.AC+"' vftype='"+item.FUELTYPE+"' vpicture='"+item.PICTURE+"' from='"+$('#from').val()+"' to='"+$('#to').val()+"' city='"+$('#city').val()+"' dcity='"+$('#dcity').val()+"' value='Book This Cab'></td></tr></table></td>";
							$c++;
							
							if($c==4) {
								$htm+='</tr>';
								$c=1;
							}
						});
			
						$htm+='</table>';
						$('#result').html($htm);
					});			
}


$(document).ready(
				function(){		
							$('#vpic').dialog({
								modal:true,
								autoOpen:false,
								title:'pictures',
								width:'auto',
								position: {my: 'center',  at: 'center', of: $('body'), within: $('body') }
							});
					
							$.getJSON('ClientCityJSON',{ajax:true},function(data) {
								$('#city').empty();
								$('#city').append($('<option>').text("Select City"));
								$('#dcity').empty();
								$('#dcity').append($('<option>').text("Select City"));
								
								$.each(data,function(i,item){
									$('#city').append($('<option>').val(item.CITYID).text(item.CITYNAME));
									$('#dcity').append($('<option>').val(item.CITYID).text(item.CITYNAME));
								});	 
							});
					
						$('#city').change(function(){
							vdisplay();
						});
						
						$('#dcity').change(function(){
							vdisplay();
						});
						
						$('#tp').keyup(function(){
							vdisplay();
						});
					
							
					$('#result').on('click','.btnpic',function(){
			//			alert($(this).attr('vid'));
						$.getJSON('VehiclePictureJSON',{ajax:true,vid:$(this).attr('vid')},function(data){
							$htm='<table cellspacing=5 class="table">';
							$c=1;
							 $.each(data,function(i,item){
								 if($c==1)
								 { $htm+='<tr cellspacing=10>';}
								 $htm+="<td><img class='img-thumbnail' src=vehiclepicture/"+item.PICTURE+" width=175 height=175></td>&emsp;";
								 $c++;
								 if($c==5)
								 { $htm+='</tr>';
								   $c=1;
								 }
							 });
							 $htm+='</table>';
							 $('#vpic').html($htm);
							 $('#vpic').dialog('open');
								
						});
					});
					
					$('#result').on('click','.btc',function(){
		//				window.location.href="ClientLogin";
						window.location.href="ClientVehicleRequest?vid="+$(this).attr('vid')+"&vn="+$(this).attr('vn')+"&vmodel="+$(this).attr('vmodel')+"&vcolor="+$(this).attr('vcolor')+"&vtype="+$(this).attr('vtype')+"&vcapacity="+$(this).attr('vcapacity')+"&vins="+$(this).attr('vins')+"&vac="+$(this).attr('vac')+"&vftype="+$(this).attr('vftype')+"&vpicture="+$(this).attr('vpicture')+"&from="+$(this).attr('from')+"&to="+$(this).attr('to')+"&city="+$(this).attr('city')+"&dcity="+$(this).attr('dcity');
					});
					
				});