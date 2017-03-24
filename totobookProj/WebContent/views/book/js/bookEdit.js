var uploadCount = 0;
var dragCount = 0;

$(document).ready(
		function() {
			var pageCount = 1;
			var selectedPage = '#bookPageRight';
			$(".bookPaging1").css("visibility", "hidden");
			$("#bookPageLeft").css("visibility", "hidden");

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

			$("#bookPageLeft").click(function() {
				selectedPage = '#bookPageLeft';
				console.log("L");
			});
			$("#bookPageRight").click(function() {
				selectedPage = '#bookPageRight';
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
				if (pageCount == 1) {
					$(this).css("visibility", "hidden");
					$("#bookPageLeft").css("visibility", "hidden");
					$(".bookPaging1").css("visibility", "hidden");
				} else if (pageCount == 4) {
					console.log("호");
					$("#bookPageRight").css("visibility", "visible");
					$(".bookPaging2").css("visibility", "visible");
					$("#toNextPage").css("visibility", "visible");
				}

			});

			$("#toNextPage").click(function() {
				pageCount = parseInt(pageCount + 1);
				console.log(pageCount);

				$("#toBeforePage").css("visibility", "visible")
				if (pageCount == 2) {
					$("#bookPageLeft").css("visibility", "visible");
					$(".bookPaging1").css("visibility", "visible");
				}
				if (pageCount == 5) {
					console.log("마지막");
					$(this).css("visibility", "hidden");
					$("#bookPageRight").css("visibility", "hidden");
					$(".bookPaging2").css("visibility", "hidden");
				}

			});

			var element = $("#bookPageRight"); // global variable
			var getCanvas; // global variable

			$("#btn-Preview-Image").on('click', function() {
				html2canvas(element, {
					onrendered : function(canvas) {
						$("#previewImage").append(canvas);
						getCanvas = canvas;
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
	console.log(id);
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
		} else {
			ev.target.appendChild(nodeCopy);

			imgCutting(ev.target);

		} // else 끝

	}

	var images = document.querySelectorAll('.image');
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
			guides : false,
			highlight : false,
			cropBoxMovable : false,
			cropBoxResizable : false,
			toggleDragModeOnDblclick : false,
		}));
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
