package hanter;

public enum CategoryEnum {
    MALE(1, 0,  0, "남자"),
    FEMALE(2, 0,  0, "여자"),
    EXO(11, 1,  0, "엑소"),
    BTS(12, 1,  0, "방탄소년단"),
    BLACK_PINK(21, 2,  0, "블랙핑크"),
    EXO_PUBLIC(111, 11,  1, "공지사항"),
    EXO_CHEN(112, 11,  2, "첸"),
    EXO_BAEK_HYEON(113, 11,  3, "백현"),
    EXO_XIUMIN(114, 11,  4, "시우민"),
    BTS_PUBLIC(121, 12,  5, "공지사항"),
    BTS_ANONYMOUS(122, 12,  6, "익명게시판"),
    BTS_V(123, 12,  7, "뷔"),
    BLACK_PINK_PUBLIC(211, 21,  8, "공지사항"),
    BLACK_PINK_ANONYMOUS(212, 21,  6, "익명게시판"),
    BLACK_PINK_ROSE(213, 21, 9, "로제")
    ;
    final int idx; // 카테고리 idx
    final int parentIdx; // parent_idx
    final int postNum; // 게시판 번호
    final String name; // 카테고리 이름


    CategoryEnum(int idx, int parentIdx, int postNum, String name) {
        this.idx = idx;
        this.parentIdx = parentIdx;
        this.postNum = postNum;
        this.name = name;
    }
}
