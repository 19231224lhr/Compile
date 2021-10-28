# Compile lab2

BUAA 编译原理实验 lab2

> 19231224 卢恒润

本次实验经历三个版本：

**第一个版本**：使用投机取巧的方法过了测试点

**第二次重构**：利用网络上的表达式求解算法进行复制，并进行了相应修改后通过了测试点，但是具体实现原理依然不知道

**第三次重构**：将算符优先算法完全自己编写，并改进了输出，将版本二只能输出结果而不能输出中间的LLVM IR指令的输出修改为了输出中间的LLVM IR指令的形式，便于之后代码的维护。

### 本次实验提示

**为什么我直接返回数值和使用LLVM IR表达式返回数值的结果是一样的？**

LLVM IR表达式实质上就是生成你最后直接返回数值的中间步骤，他详细的说明了每一个运算符号所利用的寄存器的方式，因此你直接输出结果和将生成结果的过程输出最终得到的答案是一样的。

但是，直接生成结果的方式按助教的话来讲非常不利于以后的代码维护，这也就是为什么我在第三次重构时将代码重构为了输出中间过程的LLVM IR版本。

> 举个例子
>
> 对于代码
>
> ```c
> int main() {
>  return 1 +-+ (- - -15) / 0x5;
> }
> ```
>
> 而言，我们希望得到的 LLVM IR形式是
>
> ```c
> define dso_local i32 @main(){
> 	ret i32 4
> }
> ```
>
> 如果将中间过程表示出来，那么我们就可以得到
>
> ```c
> define dso_local i32 @main(){
> %x0 = sub i32 0,15
> %x1 = sdiv i32 %x0,5
> %x2 = sub i32 1,%x1
> ret i32 %x2
> }
> ```
>
> 两种形式最后的结果都是返回了4，但是第二种形式把计算过程的中间步骤寄存器调用也表示了出来。

### jar包配置问题

在本次实验的最后，通过命令行运行jar包文件报错：

```shell
C:\Users\lhr4108\Desktop\编译原理实验>java -jar untitled1.jar .\test.txt .\test1.txt

untitled1.jar中没有主清单属性

java -jar lab2.jar $input $ir
--- stderr ---
no main manifest attribute, in lab2.jar
[ 1 ]
```

通过查找相关资料得知，原因是jar包配置文件错误，使得java命令在jar包中没有找到类的入口

解决办法：修改jar包中的文件`MANIFEST.MF`，使用记事本打开，在文件末尾添加java命令类入口：`Main-Class: 包名 类名`，**注意Main-Class: 后面有一个空格**，否则java命令报错`Error: Invalid or corrupt jarfile untitled1.jar`

我这里添加的是：`Main-Class: Main`

之后替换掉原jar包中的同名文件，注意要在解压软件中替换，之后运行java命令即可正常运行。

具体方法见链接：https://www.cnblogs.com/shaosks/p/9984350.html

https://my.oschina.net/u/3523885/blog/1557350

但这也意味着每次重新搭建jar包时都要修改，现在也不知道有什么更好的办法。

![image-20211027174110344](../../../AppData/Roaming/Typora/typora-user-images/image-20211027174110344.png)

### 关于Antlr4与算符优先分析法的构造方法我尽量记录在视频中。

