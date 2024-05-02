package hanter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Category {

    // 최상위 카테고리 등록 및 초기화
    public static final Map<Integer, Category> categoryMap = new HashMap<Integer, Category>() {
        {
            put(0, new Category(0, null, new ArrayList<>(), 0, "카테고리"));
        }
    };

    public final int idx; // 카테고리 idx
    @JsonIgnore
    public Category parent; // parent
    @JsonInclude(Include.NON_EMPTY)
    public final List<Category> childList; // child
    @JsonInclude(Include.NON_DEFAULT)
    public final int postNum; // 게시판 번호
    public final String name; // 카테고리 이름

    public Category(int idx, Category parent, List<Category> childList, int postNum, String name) {
        this.idx = idx;
        this.parent = parent;
        this.childList = childList;
        this.postNum = postNum;
        this.name = name;
    }

    // 최상위 카테고리
    public static Category root() {
        return categoryMap.get(0);
    }

    // idx로 검색
    public static Category findByIdx(int idx) {
        return categoryMap.get(idx);
    }

    // 카테고리 이름으로 검색
    public static Category findByName(String name) {
        for (Entry<Integer, Category> entry : categoryMap.entrySet()) {
            if (entry.getValue().name.equals(name)) {
                return categoryMap.get(entry.getKey());
            }
        }
        return null;
    }
}
