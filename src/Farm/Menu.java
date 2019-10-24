package Farm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/*
 * 菜单类，该类是一个模板类，可供动物/植物/工具使用
 * 在这里实现Iterator
 */
public class Menu<T>{
    private List<T> _menu;

    public Menu(){
        this._menu = new ArrayList<>();
    }

    void add(T item){
        for (T item_ : _menu){
            if(item_.equals(item)){
                return;
            }
        }
        _menu.add(item);
    }

    void erase(T item){
        _menu.remove(item);
    }

    class MenuIterator implements Iterator<T>{
        private int index = 0;
        private List<T> items;

        MenuIterator(Menu<T> menu){
            index = 0;
            items = menu._menu;
        }

        @Override
        public boolean hasNext(){
            return index < _menu.size();
        }

        @Override
        public T next(){
            assert index < _menu.size();
            return _menu.get(index++);
        }

        @Override
        public void remove(){
            try {
                throw new NoSuchMethodException("TODO");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
    }
}
