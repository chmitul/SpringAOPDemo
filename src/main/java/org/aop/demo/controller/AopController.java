package org.aop.demo.controller;

import lombok.RequiredArgsConstructor;
import org.aop.demo.service.AopService;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/aop")
@RequiredArgsConstructor
@RestController
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AopController
{
	private final AopService aopService;

	@GetMapping(value = "/test1")
	public ResponseEntity<Long> test1()
	{
		Long result = aopService.testing1();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/test2")
	public ResponseEntity<Long> test2()
	{
		Long result = aopService.testing2();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/test3")
	public ResponseEntity<Long> test3()
	{
		Long result = aopService.testing3();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/test4")
	public ResponseEntity<Long> test4()
	{
		Long result = aopService.testing4();
		return ResponseEntity.ok(result);
	}

	@GetMapping(value = "/test5/{a}/{b}")
	public ResponseEntity<Long> test5(@PathVariable int a , @PathVariable int b)
	{
		Long result = aopService.testing5(a , b);
		return ResponseEntity.ok(result);
	}
}
