$(document).ready(
		function(){
					
	/*				$.getJSON("AgencyJSON",{ajax: true},function(data) {
							
						$.each(data,function(i,item){
							$('#agency').append($('<option>').val(item.AGENCYID).text(item.AGENCYID));
						});
					});*/
					
				//	$('#agency').change(function() {
				//		console.log($('#agency').val());
					$('#vehicle').append($('<option>').text("Select VehicleId"));
					$.getJSON('VehicleJSON',{ajax:true,agencyid:$('#agency').val()},function(data){
				//		$('#vehicle').empty();
				//			$('#vehicle').append($('<option>').text("Select VehicleId"));
							$.each(data,function(i,item){
								$('#vehicle').append($('<option>').val(item.VEHICLEID).text(item.VEHICLEID));
							});
						});
					});
	//	});