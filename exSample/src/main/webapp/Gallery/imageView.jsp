<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width,initial-scale=1" />
  <title>Image File Preview</title>
  <style>
    body { font-family: system-ui, -apple-system, "Segoe UI", Roboto, "Noto Sans KR", Arial; padding: 20px; }
    .uploader { max-width: 800px; margin: 0 auto; }
    .dropzone {
      border: 2px dashed #bbb; border-radius: 8px; padding: 24px;
      display: flex; gap: 12px; align-items: center; justify-content: center;
      flex-direction: column; color: #444; transition: border-color .15s, background .15s;
    }
    .dropzone.dragover { border-color: #0078d4; background: #f4fbff; }
    .controls { display:flex; gap:8px; align-items:center; margin-bottom:12px; }
    input[type=file] { display: none; }
    .btn { padding:8px 12px; border-radius:6px; border:1px solid #ccc; background:#fff; cursor:pointer; }
    .btn.primary { background:#0078d4; color:white; border-color:#0078d4; }
    #preview { display:flex; gap:12px; flex-wrap:wrap; margin-top:12px; }
    .thumb {
      width:140px; border-radius:8px; overflow:hidden; border:1px solid #e0e0e0;
      box-shadow: 0 2px 6px rgba(0,0,0,0.06); position:relative; background:#fff;
    }
    .thumb img { display:block; width:100%; height:100px; object-fit:cover; }
    .thumb .meta { padding:8px; font-size:13px; color:#333; }
    .thumb .remove {
      position:absolute; top:6px; right:6px; background:rgba(255,255,255,0.9); border-radius:6px;
      padding:4px 6px; font-size:12px; cursor:pointer; border:1px solid #ddd;
    }
    .small { font-size:12px; color:#666; }
  </style>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
</head>
<body>
  <div class="uploader">
    <h2>이미지 업로드 미리보기</h2>
    <div class="controls">
      <label class="btn primary" id="btnSelect">이미지 선택</label>
      <button class="btn" id="btnClear">모두 지우기</button>
      <div class="small">허용: 이미지 파일만 (최대 5MB / 파일)</div>
    </div>

    <div class="dropzone" id="dropzone">
      <div>이미지를 끌어다 놓거나 <strong>이미지 선택</strong> 버튼을 누르세요.</div>
      <input id="fileInput" type="file" accept="image/*" multiple>
    </div>

    <div id="preview" aria-live="polite"></div>
  </div>

  <script>
(function(){
  const fileInput = document.getElementById('fileInput');
  const btnSelect = document.getElementById('btnSelect');
  const btnClear = document.getElementById('btnClear');
  const preview = document.getElementById('preview');
  const dropzone = document.getElementById('dropzone');

  const MAX_FILE_SIZE = 5 * 1024 * 1024; 
  const ALLOWED_TYPES = ['image/jpeg','image/png','image/gif','image/webp','image/svg+xml'];

  btnSelect.addEventListener('click', () => fileInput.click());

  fileInput.addEventListener('change', (e) => {
    handleFiles(e.target.files);
    fileInput.value = '';
  });

  ['dragenter','dragover'].forEach(ev => {
    dropzone.addEventListener(ev, (e) => {
      e.preventDefault(); 
      dropzone.classList.add('dragover');
    });
  });

  ['dragleave','drop'].forEach(ev => {
    dropzone.addEventListener(ev, (e) => {
      e.preventDefault(); 
      dropzone.classList.remove('dragover');
    });
  });

  dropzone.addEventListener('drop', (e) => {
    const dt = e.dataTransfer;
    if (!dt) return;
    handleFiles(dt.files);
  });

  function handleFiles(fileList) {
    const files = Array.from(fileList);
    if (!files.length) return;

    files.forEach(file => {
      if (!ALLOWED_TYPES.includes(file.type)) {
        alert("허용되지 않는 파일 형식: " + file.name);
        return;
      }
      if (file.size > MAX_FILE_SIZE) {
        alert("파일이 너무 큽니다(최대 5MB): " + file.name);
        return;
      }

      const url = URL.createObjectURL(file);
      const thumb = createThumbnail(url, file);
      preview.appendChild(thumb);
    });
  }

  function createThumbnail(objectUrl, file) {
    const box = document.createElement('div');
    box.className = 'thumb';

    const removeBtn = document.createElement('button');
    removeBtn.className = 'remove';
    removeBtn.textContent = '삭제';

    const img = document.createElement('img');
    img.src = objectUrl;
    img.alt = file.name;

    const meta = document.createElement('div');
    meta.className = 'meta';
    meta.textContent = file.name + " (" + formatBytes(file.size) + ")";

    removeBtn.addEventListener('click', () => {
      box.remove();
      URL.revokeObjectURL(objectUrl);
    });

    box.appendChild(removeBtn);
    box.appendChild(img);
    box.appendChild(meta);
    return box;
  }

  btnClear.addEventListener('click', () => {
    preview.querySelectorAll('img').forEach(img => {
      try { URL.revokeObjectURL(img.src); } catch(e) {}
    });
    preview.innerHTML = '';
  });

  function formatBytes(bytes){
    if (bytes < 1024) return bytes + " B";
    const kb = bytes / 1024;
    if (kb < 1024) return kb.toFixed(1) + " KB";
    const mb = kb / 1024;
    return mb.toFixed(2) + " MB";
  }

})();
</script>
</body>
</html>
