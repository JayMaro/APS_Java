package hanter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;


public class No1 {

    public static final ObjectMapper om = new ObjectMapper(); // Object to JSON을 위한 ObjectMapper

    public static void main(String[] args) throws JsonProcessingException {

        // 카테고리 Enum(DB대체)에서 데이터를 불러온 뒤 정렬한 뒤 저장
        for (CategoryEnum category : Arrays.stream(CategoryEnum.values()).sorted(Comparator.comparingInt(x -> x.idx)).collect(Collectors.toList())) {
            Category post = new Category(category.idx, null, new ArrayList<>(), category.postNum, category.name);
            Category.categoryMap.put(post.idx, post); // 전체를 관리하기 위한 Map
            Category parent = Category.categoryMap.get(category.parentIdx); // 부모 카테고리
            post.parent = parent; // 생성한 카테고리의 부모 카테고리 등록
            parent.childList.add(post); // 부모 카테고리의 자식 카테고리로 등록
        }

        System.out.println(om.writeValueAsString(Category.root()));
        System.out.println(om.writeValueAsString(Category.findByIdx(21)));
        System.out.println(om.writeValueAsString(Category.findByName("첸")));
    }
}
