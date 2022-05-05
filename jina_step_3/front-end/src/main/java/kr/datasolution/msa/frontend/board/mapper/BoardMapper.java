package kr.datasolution.msa.frontend.board.mapper;

import kr.datasolution.msa.frontend.board.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/** 게시물 DB TABLE 처리 Mapper Interface */
@Mapper
public interface BoardMapper {

    /** 전체 등록 게시물 리스트 조회 */
    List<BoardDto> findAll();

    /** 지정 게시물 상세 조회 */
    BoardDto findById(int id);

    /** 게시물 등록 처리 */
    int save(BoardDto boardDto);

    /** 게시물 수정 처리 */
    int update(BoardDto boardDto);

    /**게시물 삭제 처리 */
    int deleteById(int id);
}
