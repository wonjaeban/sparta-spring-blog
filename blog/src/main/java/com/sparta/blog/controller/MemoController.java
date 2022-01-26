package com.sparta.blog.controller;

import com.sparta.blog.domain.Memo;
import com.sparta.blog.domain.MemoRepository;
import com.sparta.blog.domain.MemoRequestDto;
import com.sparta.blog.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class MemoController {
    private final MemoRepository memoRepository;
    private final MemoService memoService;

    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto) {
        Memo memo = new Memo(requestDto);
        return memoRepository.save(memo);
    }

    @GetMapping("/api/memos")
    public List<Memo> getMemos() {
        return memoRepository.findAllByOrderByCreatedAtDesc();
    }

    @GetMapping("/api/lookup")
    public Optional<Memo> getLookup(@RequestParam(value="id") Long idInput) {
        return memoRepository.findById(idInput);

    }

}