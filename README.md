# あ…ありのまま 今　起こった事を話すぜ！

gsonのデシリアライズのサンプルを書こうと思っていたら  
いつの間にか コンストラクタを呼ばずにインスタンスを作っていた..!  

な... 何を言っているのか わからねーと思うが  
おれも　sun.misc.Unsafeが何をしているのか　わからなかった....  

頭がどうにかなりそうだった...  
refrection(newInstance)だとか  
byte code 書き換えとか  

そんなチャチなもんじゃあ　断じてねえ  
もっと恐ろしいものの片鱗を　味わったぜ...  

unsafeつかっているところ
https://github.com/tomlla/gsonexmaple/blob/master/src/main/java/gsonexample/DeserializeToJavaObject.java#L13
