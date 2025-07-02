import 'package:flutter/material.dart';
import 'package:http/http.dart' as http;
import 'dart:convert';

class RegisterPage extends StatefulWidget {
  const RegisterPage({super.key});

  @override
  State<RegisterPage> createState() => _RegisterPageState();
}

class _RegisterPageState extends State<RegisterPage> {
  final usernameController = TextEditingController();
  final passwordController = TextEditingController();
  final fullNameController = TextEditingController();
  String selectedRole = 'staff';
  String message = '';

  Future<void> register() async {
    final url = Uri.parse('http://localhost:8080/api/auth/register');

    final response = await http.post(
      url,
      headers: {'Content-Type': 'application/json'},
      body: jsonEncode({
        'username': usernameController.text,
        'password': passwordController.text,
        'fullName': fullNameController.text,
        'role': selectedRole,
      }),
    );

    if (response.statusCode == 200) {
      setState(() => message = 'Đăng ký thành công!');
    } else {
      setState(() => message = 'Đăng ký thất bại!');
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Đăng ký')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          children: [
            TextField(controller: fullNameController, decoration: const InputDecoration(labelText: 'Họ tên')),
            TextField(controller: usernameController, decoration: const InputDecoration(labelText: 'Tên đăng nhập')),
            TextField(controller: passwordController, obscureText: true, decoration: const InputDecoration(labelText: 'Mật khẩu')),
            DropdownButtonFormField<String>(
              value: selectedRole,
              items: const [
                DropdownMenuItem(value: 'admin', child: Text('Admin')),
                DropdownMenuItem(value: 'manager', child: Text('Manager')),
                DropdownMenuItem(value: 'staff', child: Text('Staff')),
              ],
              onChanged: (value) => setState(() => selectedRole = value!),
              decoration: const InputDecoration(labelText: 'Vai trò'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(onPressed: register, child: const Text('Đăng ký')),
            TextButton(
              onPressed: () => Navigator.pushNamed(context, '/login'),
              child: const Text('Đã có tài khoản? Đăng nhập'),
            ),
            if (message.isNotEmpty) Text(message),
          ],
        ),
      ),
    );
  }
}
