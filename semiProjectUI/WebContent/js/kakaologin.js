//<![CDATA[
    // 사용할 앱의 JavaScript 키를 설정해 주세요.
    Kakao.init('9cf5622e3400d24c091a552cd507d917');
    // 카카오 로그인 버튼을 생성합니다.
    Kakao.Auth.createLoginButton({
      container: '#kakao-login-btn',
      success: function(authObj) {
        // 로그인 성공시, API를 호출합니다.
        Kakao.API.request({
          url: '/v2/user/me',
          success: function(res) {
            alert(JSON.stringify(res));
            
            
                
                $.ajax({
                   url:"servlet.do?command=kakaologin",
                   method:"post",
                   data:{"obj":JSON.stringify(res)},
                   
                   success:function(msg){//여기에 insert 한 result가 옴
                  	                	   
                   alert(msg);   
                   
                   },
                   error:function(){
                      alert("실패");
                   }
                });
             
          },
          fail: function(error) {
            alert(JSON.stringify(error));
          }
        });
      },
      fail: function(err) {
        alert(JSON.stringify(err));
      }
    });
  //]]>
    
    
    
    /**
 * 
 */