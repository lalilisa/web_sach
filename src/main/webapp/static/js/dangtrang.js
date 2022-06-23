    	 
var tensach=window.location.href.split("/")[6] 
    	 
    	  $(document).ready(function() {

    		    $('#form_dang_truyen').submit(function() {
    		      $(this).ajaxSubmit({
    		          type:'POST',
    		          url:`${contextPath}/api/trangtruyen/${tensach}`,
    		          error: function(xhr) {
    		     			console.log(xhr.status)
    		          },

    		      success: function(response) {
    		            console.log(response)
    		              alert(response)
    		          }
    		  });
    		  return false;
    		  });    
    		  });



    		  

