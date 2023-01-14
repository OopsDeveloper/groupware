/*!
 * Navigation
 * Last Date : 21.09.27
 */

(function fn_nav() {
	var myHref = window.location.href;
	var myOri = window.location.origin;
	var realHref = myHref.replace(myOri+'/', '');	
	var myDir = realHref.split('/');//현재 주소 폴더
	//console.log( 'myDir:'+myDir ); 
	
	
	/**
	 * DropDown, widget
	 */
	var appWiget = $('.widget .dropdown-item');  
	console.log( appWiget ); 
	//console.log( appWiget );
	for( var i=0; i<appWiget.length; i++ ) {
		var item = $(appWiget).eq(i).data('src');
		console.log( 'myDir[1]:'+myDir[1] ); 
		console.log( 'item:'+item ); 
		if( myDir[1] == item ) {
			$(appWiget).eq(i).addClass('active');
			break;
		/*} else if ( myDir[1] == item+'2' ) {
			$(appWiget).eq(i).addClass('active');
			break;*/
		}
	}//for - $('.widget .dropdown-item'); 
	
	
	/**
	 * Navigation
	 */
	var menuLen = $('#navigation .vertical-nav > li');
	for( var i=0; i<menuLen.length; i++ ) {
		var menunm = $(menuLen).eq(i).data('src');
		//console.log( i, menunm, myDir[0] );
		
		if( myDir[0] == menunm ) {
			$(menuLen).eq(i).addClass('active');
			$(menuLen).eq(i).find('a').addClass('active');
			
			var childNum = $(menuLen).eq(i).children().length;
			var depthChild = $(menuLen).eq(i).children().hasClass('mm-menu');
			var childLen = $('.mm-menu > li');
			if( childNum != 'undefined' ) {
				$(menuLen).find('.mm-menu').addClass('show');
				
				var myDirChild = myDir[1].split('?');
				for( var j=0; j<childLen.length; j++ ) {
					var temp = $(childLen).eq(j).data('src');
						
					if( myDirChild[0] == temp ) {
						$(childLen).eq(j).find('a').addClass('active');
						console.log( $(childLen).eq(j).find('a') );
					} else if( myDirChild[1] != temp ) {
						$(childLen).eq(j).find('a').removeClass('active');
					}					
				}				
			}//if( childNum != 'undefined' )
		} else if( myDir[0] != menunm ) {
			$(menuLen).eq(i).removeClass('active');
			$(menuLen).eq(i).find('a').removeClass('active');
		}
		
	}//for( var i=0; i<menuLen.length; i++ )

})();//function fn_nav() 메뉴

//fn_nav();//초기화 


