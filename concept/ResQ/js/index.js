var number = 1;
var number2 = 1;

function swapImageFirstPhone()
{
	var image = document.getElementById('firstphone');
	var phoneScreens = [];
	phoneScreens[0] = "design/fp01.png";
	phoneScreens[1] = "design/fp02.png";
	phoneScreens[2] = "design/fp03.png";
	phoneScreens[3] = "design/fp04.png";
	phoneScreens[4] = "design/fp05.png";
	phoneScreens[5] = "design/fp06.png";
	phoneScreens[6] = "design/fp07.png";
	phoneScreens[7] = "design/fp08.png";


	if(number < phoneScreens.length)
	{
		image.src = phoneScreens[number];
		number++;

		if(number == 5)
		{
    			$("#firstphone").click(function(){
        			$("#firstphone").animate({right: '300px'})
        				$("#secondphone").delay(400).animate({right: '100px', opacity: 1})
        					$("#secondphone").attr('width','408px')
        					$("#secondphone").effect( "shake", {times:2}, 700)
        						$("#secondphone").attr('id','#responder');
    				});	
    	}
	}
	else 
	{
		number = 0;
		image.src = phoneScreens[number];
	}
}

function swapImageSecondPhone()
{
	var image = document.getElementsByClassName('second');
	var phoneScreens = [];
	phoneScreens[0] = "design/sp01.png";
	phoneScreens[1] = "design/sp02.png";
	phoneScreens[2] = "design/sp03.png";
	phoneScreens[3] = "design/sp04.png";
	phoneScreens[4] = "design/sp05.png";
	phoneScreens[5] = "design/sp06.png";

	if(number2 < phoneScreens.length  )
	{
		image[0].src = phoneScreens[number2];
		number2++;
	}
	else 
	{
		number2 = 0;
		image[0].src = phoneScreens[number2];
	}
}

