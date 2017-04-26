package com.lxy.customerinfomanager.util;
/**
 * 不是管理员，则限制权限
 * @author xiaoyang
 *
 */
public class IsRoot {
	//检查到非管理员登录，则会设置为true。
	public static boolean flag=false;
}
//其实这个方法用的很简单，我就直接用了static方法，可作为类的函数直接调用。
//这个函数的设置还是有bug的，没有进行database的束缚，而是直接设置了个简单的flag。
