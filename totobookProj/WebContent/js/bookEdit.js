var uploadCount = 0;
var dragCount = 0;

$(document).ready(
		function() {
			var pageCount = 0;
			var maxPage = ($("#pageCount").val())/2;
			console.log("maxPage"+maxPage);
			var selectedPage = '#bookPage1';
			var currentLeftPage = '#bookPage0';
			var currentRightPage = selectedPage
			$(".bookPaging1").css("visibility", "hidden");
			$("#bookPage2").css("visibility", "hidden");
			$("#bookPage2").css("display", "inline");
			$("#bookPage1").css("visibility", "visible");
			$("#bookPage1").css("display", "inline");

			var beforeLayout = function() {
				$(".layoutIcon2").css("display", "none");
				$(".layoutIcon1").css("display", "block");
				$('#BeforeBtnImg').css("display", "none");
				$('#NextBtnImg').css("display", "block");
			}
			var nextLayout = function() {
				$(".layoutIcon1").css("display", "none");
				$(".layoutIcon2").css("display", "block");
				$('#BeforeBtnImg').css("display", "block");
				$('#NextBtnImg').css("display", "none");
			}

			$(".LeftPageDiv").click(function() {
				selectedPage = currentLeftPage;
				console.log("L");
			});
			$(".RightPageDiv").click(function() {
				selectedPage = currentRightPage;
				console.log("R");
			});

			$(".layoutIcon1").click(function() {
				var src = $(this).attr("src");
				$(selectedPage).empty();

				var node1 = document.createElement("div");
				node1.id = "photoLayoutDiv1";
				console.log("뭐여1");
				if (src == "/totobookProj/views/book/A3_layout_1.jpg") {
					console.log("뭐여");
					node1.className = "container";
					$(selectedPage).append(node1);
				}
				if (src == "/totobookProj/views/book/A3_layout_2.jpg") {
					node1.className = "photoLayoutMedium";
					node1.setAttribute("style", "margin-top:45%")
					$(selectedPage).append(node1);
				}
				if (src == "/totobookProj/views/book/A3_layout_3.jpg") {
					node1.className = "photoLayoutMedium";
					node1.setAttribute("style", "margin : 10% auto");
					var node2 = node1.cloneNode(true);
					node2.id = "photoLayoutDiv2";
					$(selectedPage).append(node1);
					$(selectedPage).append(node2);
				}
			});

			$("#toBeforePage").click(function() {
				console.log(pageCount);
				pageCount = parseInt(pageCount - 1);
				
				currentLeftPage.css("display", "none");
				currentLeftPage= '#bookLeftPage'+((pageCount*2)-1);
				
				if (pageCount == 0) {
					$(this).css("visibility", "hidden");
					$("#bookPage2").css("visibility", "hidden");
					$("#bookPage2").css("display", "inline");
					$(".bookPaging1").css("visibility", "hidden");
				} else if (pageCount == (maxPage-1)) {
					console.log("호");
					$("#bookPage5").css("visibility", "visible");
					$(".bookPaging2").css("visibility", "visible");
					$("#toNextPage").css("visibility", "visible");
				}
				if(pageCount !=1 && pageCount != (maxPage-1)){
					console.log(pageCount);
					console.log(currentLeftPage);
					console.log(currentRightPage);
					
					currentRightPage = '#bookPage'+((pageCount*2)-1);
					currentLeftPage = '#bookPage'+((pageCount*2)-2);
				}
			});

			$("#toNextPage").click(function() {
				pageCount = parseInt(pageCount + 1);
				console.log(pageCount);
				
				//기존에 보여준 페이지를 hidden으로 바꾼다.
				$(currentRightPage).css("display", "none");
				$(currentRightPage).css("visibility","hidden");
				$(currentLeftPage).css("display","none");
				$(currentLeftPage).css("visibility","hidden");
				//뒤로 가는 버튼 보여주기
				$("#toBeforePage").css("visibility", "visible")
				
				
				//1번째면 paging1 보여주기
				if (pageCount == 1) {
					$(".bookPaging1").css("visibility", "visible");					
				}				
				
				//마지막이면 paging2와 버튼 없애기
				if (pageCount == maxPage) {
					console.log("마지막");
					$(this).css("visibility", "hidden");
					$(".bookPaging2").css("visibility", "hidden");	
					$(currentRightPage).css("display","inline");		
				}
				
				//currentPage update
				console.log(pageCount);
				console.log("과거"+currentLeftPage);
				console.log(currentRightPage);
				currentLeftPage = '#bookPage'+(pageCount*2);
				currentRightPage = '#bookPage'+((pageCount*2)+1);
				console.log("현재?"+currentLeftPage);
				console.log(currentRightPage);			

				
				//currentPage를 visibility로 변경
				$(currentLeftPage).css("visibility", "visible");
				$(currentRightPage).css("visibility", "visible");
				$(currentLeftPage).css("display", "inline");
				$(currentRightPage).css("display", "inline");
				

			/*	
			 * 
			 * 				
					$("#bookPage"+((maxPage*2)-1)).css("visibility", "hidden");
					$(".bookPaging2").css("visibility", "hidden");
				if(pageCount !=1 && pageCount != maxPage){
					$(currentRightPage).css("display", "none");
					$(currentRightPage).css("visibility","hidden");
					$(currentLeftPage).css("display","none");
					$(currentLeftPage).css("visibility","hidden");
				}*/


			});

			var element = $("#bookPageRight");
			var getCanvas;
			$("#saveBook").on('click', function() {
				html2canvas(element, {
					onrendered : function(canvas) {
						console.log("뭐야wwzzw이거");
						
						$("#imgSrc").val(canvas.toDataURL("image/png"));
						var params = $("#photoForm").serialize();
						var whar = 'whar';
	                
						console.log(whar);
	                    $.ajax({
	                        type: "post",
	                        data : $("form").serialize(),
	                        url: "pageUpload.do",
	                        error: function(a, b, c){        
	                            alert("fail!!");
	                        },
	                        success: function (data) {
	                            try{
	                            	(this).submit();
	                                
	                            }catch(e){                
	                                alert('server Error!!');
	                            }
	                        }
	                    });
					}
				});
			});
			
			$("#btn-Convert-Html2Image").on(
					'click',
					function() {
						var imgageData = getCanvas.toDataURL("image/png");
						// Now browser starts downloading it instead of just
						// showing it
						var newData = imgageData.replace(/^data:image\/png/,
								"data:application/octet-stream");
						$("#btn-Convert-Html2Image").attr("download",
								"your_pic_name.png").attr("href", newData);
					});

		});

var fileInfo = function(f) {
	var file = f.files; // files 를 사용하면 파일의 정보를 알 수 있음

	// 파일의 갯수만큼 반복
	for (var i = 0; i < file.length; i++) {

		var reader = new FileReader(); // FileReader 객체 사용
		reader.onload = function(rst) {

			$('#img_box')
					.append(
							'<img id="uploadedImg'
									+ uploadCount
									+ '" src="'
									+ rst.target.result
									+ '" class="uploadPhoto" draggable="true" ondragstart="drag(event)">');

			uploadCount++;
		}
		reader.readAsDataURL(file[i]); // 파일을 읽는다

	}
}
var allowDrop = function(ev) {
	ev.preventDefault();
}

// drag 시 발생
var drag = function(ev) {
	ev.dataTransfer.setData("text", ev.target.id);
}

// drop 시 발생
var drop = function(ev) {
	ev.preventDefault();
	var data = ev.dataTransfer.getData("text");
	var id = ev.target.id;
	var classN = ev.target.className;

	if ((id != 'bookPageRight') && (id != 'bookPageLeft')) {
		var nodeCopy = document.getElementById(data).cloneNode(true);
		// nodeCopy.id = data+"_"+dragCount++;

		nodeCopy.id = data.id + "image" + dragCount;
		nodeCopy.className = 'image';
		nodeCopy.setAttribute('draggable', false);

		if (ev.target.nodeName == "SPAN") {
			var parent = ev.target.parentElement.parentElement.parentElement;
			console.log(parent.id);
			while (parent.hasChildNodes()) {	
				parent.removeChild(parent.firstChild);
			}
			parent.appendChild(nodeCopy);
			imgCutting(parent);
		} if(ev.target.nodeName == "IMG") {
			var parent = ev.target.parentElement;
			console.log(parent.id);
			while (parent.hasChildNodes()) {	
				parent.removeChild(parent.firstChild);
			}
			parent.appendChild(nodeCopy);
			imgCutting(parent);
		} if (ev.target.nodeName == "DIV"){
			ev.target.appendChild(nodeCopy);

			imgCutting(ev.target);
		}
		// else 끝
	}
	$("#"+nodeCopy.id).removeClass("image");
	
	  
		  var images = document.querySelectorAll('#'+nodeCopy.id);
	      var length = images.length;
	      var croppers = [];
	      var i;
	  	for (i = 0; i < length; i++) {
			croppers.push(new Cropper(images[i], {
				viewMode : 3,
				dragMode : 'move',
				autoCropArea : 1,
				restore : false,
				modal : false,
				guides : true,
				highlight : false,
				cropBoxMovable : false,
				cropBoxResizable : false,
				toggleDragModeOnDblclick : false,
			}));

			console.log("크로퍼 생성"+i);
		}
	  
	

}

var imgCutting = function(targetDiv) {

	var divAspect = targetDiv.offsetHeight / targetDiv.offsetWidth;
	targetDiv.style.overflow = 'hidden';

	var img = targetDiv.querySelector('img');
	var imgAspect = img.height / img.width;

	if (imgAspect <= divAspect) {
		console.log("납작잼");
		var imgWidthActual = targetDiv.offsetHeight / imgAspect;
		var imgWidthToBe = targetDiv.offsetHeight / divAspect;
		var margin = -Math.round((imgWidthActual - imgWidthToBe) / 2);
		img.style.cssText = 'width: auto; height: 100%; margin-left:' + margin
				+ ';';
	} else {
		img.style.cssText = 'width: 100%; height: auto; margin-left: 0;';
	}
}
