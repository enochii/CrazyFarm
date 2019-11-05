package Farm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * 菜单类，该类是一个[模板类]，可供动物/植物/工具使用
 * 在这里实现Iterator模式
 */
public class Menu<T> implements Iterable<T>, Serializable {
    private List<T> _menu;
    /*
     * 构造函数
     */
    public Menu(){
        this._menu = new ArrayList<>();
    }

    /*
     * @param : item 加入的项目
     * 向菜单中加入一个项目
     */
    public void add(T item){
        for (T item_ : _menu){
            if(item_.equals(item)){
                return;
            }
        }
        _menu.add(item);
    }

    /*
     * @param : item 移除的项目
     * 从菜单中移除一个项目
     */
    public void erase(T item){
        _menu.remove(item);
    }

    /*
     * @return : 迭代器
     * 向外提供的迭代器接口
     * 用户可以通过这个函数遍历菜单项
     */
    public Iterator<T> iterator(){
        return new MenuIterator(this);
    }

    public int getSize() { return _menu.size(); }

    /*
     * 迭代器类，实现迭代器模式，供对应的Menu类调用
     */
    class MenuIterator implements Iterator<T>{
        private int _index = 0;
        private List<T> _items;

        MenuIterator(Menu<T> menu){
            System.out.println("======== 使用迭代器 Iterator 模式=========");
            System.out.println("你初始化了一个菜单迭代器（迭代器 Iterator模式）");
            _index = 0;
            _items = menu._menu;
        }

        /*
         * 以下hasNext() next() remove()均为重载Iterator<T>实现的方法
         */
        @Override
        public boolean hasNext(){
            return _index < _menu.size();
        }

        @Override
        public T next(){
            assert _index < _menu.size();
            return _items.get(_index++);
        }

        @Override
        public void remove(){
            System.out.print("UnSupported Op");
        }
    }
}
