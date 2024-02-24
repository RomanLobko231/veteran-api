package com.rvs.api;

import com.rvs.api.model.NewsArticle;
import com.rvs.api.repository.NewsArticleRepository;
import com.rvs.api.service.NewsArticleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}


	@Bean
	CommandLineRunner run(NewsArticleRepository repository){
		return args -> {
			NewsArticle article1 = new NewsArticle(null, "Посттравматичний стресовий розлад в умовах війни (ПТСР)", """
					Психологічний стан та психічне здоров’я під час військових дій є вкрай важливим. Багато людей переживають виснаження, спустошення, втому, відчувають тривогу й паніку. Психологи сформулювали корисні поради, як опанувати себе в критичних умовах, як допомогти близьким та підтримувати здоровий психічний стан в критичних умовах.\s
					     
					Посттравматичний стресовий розлад — це порушення психічного стану, що може розвинутися після травматичної події. Близько 8% чоловіків та 20% жінок, які пережили травматичні події, мають ПТСР.\s
					     
					У кого може статись ПТСР\s
					     
					Посттравматичний стресовий розлад може розвинутисьу людей, які:\s
					     
					втратили на війні рідних, друзів, побратимів;\s
					     
					бачили вбитих;\s
					     
					стріляли;\s
					     
					перебували чи перебувають під обстрілами чи бомбардуваннями;\s
					     
					непокоїлися через рідних чи друзів, які в небезпеці;\s
					     
					почувалися залишеними, самотніми та зрадженими;\s
					     
					стали свідком теракту;\s
					     
					потрапили в полон чи в оточення.\s
					     
					Симптоми посттравматичного стресового розладу\s
					     
					постійні та неконтрольовані думки про травматичні події, сни про них;\s
					     
					відчуття постійної небезпеки;\s
					     
					надмірна збудженість;\s
					     
					уникнення згадок про травму;\s
					     
					панічні атаки: відчуття страху, поверхневе дихання, нудота, прискорене серцебиття, біль у грудях;\s
					     
					зловживання алкоголем, сигаретами чи наркотиками;\s
					     
					негаразди в буденному житті;\s
					     
					проблеми в стосунках, віддалення від партнера;\s
					     
					суїцідальні думки.\s
					     
					неспроможність висловлювати й проявляти емоції: плакати, радіти, співчувати\s
					     
					Як лікується ПТСР\s
					     
					Перш за все, пам’ятайте: ПТСР – це розлад, який лікується. І після курсу лікування ви знову зможете жити буденним життям, проявляти емоції, відчувати радість і почувати себе захищеним.\s
					     
					Лікування передбачає психотерапію та медикаментозну допомогу.\s
					     
					У разі появи симптомів ПТСР:\s
					     
					Зверніться до сімейного лікаря, психіатра або фахівця з психічного здоров’я.\s
					     
					Подбайте про першочергові потреби: фізичну безпеку, наявність харчів, питної води тощо. Відновіть режим сну. Дайте знати про свої потреби державним структурам та гуманітарним організаціям, щоб вони могли вчасно забезпечити вас необхідним.\s
					     
					Уникайте вживання алкоголю та інших шкідливих речовин. Це не допоможе забути жахіття, проте є ризик, що розвинеться залежність.\s
					     
					Звʼяжіться з близькими, друзями, родичами, дайте їм знати, що ви живі, обговоріть із ними свій досвід, поділіться переживаннями та почуттями. Якщо ви боїтеся, що ваші розповіді можуть їх травмувати, запитайте в них, чи вони готові почути все, що відбувалося. Найімовірніше, ви отримаєте ствердну відповідь.\s
					     
					Контактуйте з іншими людьми, які пережили подібний досвід, наприклад, із сусідами. Діліться з ними цими порадами.\s
					     
					Будьте готові до змін у психічному стані: після кількох днів полегшення може настати стан спустошення, виснаження, перевтоми. Це цілком природна реакція на надмірний стрес, у якому ви були весь цей час. Організму треба дати можливість відновитися.\s
					     
					Зупиняйте почуття провини. Ви можете відчувати злість та ненависть, огиду тощо. Усі негативні емоції, спрямовані на ворога й окупанта, є природними і мають право на існування. Те, що з нами зробили, заслуговує на ненависть і злість. Утім, якщо ви маєте почуття провини, варто його зупиняти. У тому, що з вами сталося, винен ворог. Саме на нього й треба спрямовувати почуття.\s
					     
					Швидкі способи самодопомоги при ПТРС\s
					     
					Ці техніки можуть бути корисними як для особистого використання, так і під час роботи з людьми з ПТСР.\s
					     
					Техніка заземлення: вправа «тут і тепер» \s
					     
					Переорієнтуйте себе в просторі й часі, ставлячи собі деякі або всі з наступних питань:\s
					     
					Де я?\s
					     
					Який сьогодні день?\s
					     
					Яке сьогодні число?\s
					     
					Який сьогодні місяць?\s
					     
					Який рік?\s
					     
					Скільки мені років?\s
					     
					 Яка зараз пора року?\s
					     
					Стабілізаційна вправа: антистресове дихання 4:8\s
					     
					Спробуйте дихати повільно. Вдих (рахуємо 1–2–3–4) — пауза (затримуємо дихання — на 1–2) — видих (рахуємо 1–2–3–4–5–6–7–8). Важливо, щоби видих був удвічі довшим. Робіть цю вправу не менше 10 разів. Уявляйте, що ви «видихаєте» напругу.\s
					     
					Інтелектуальне заземлення\s
					     
					Детально опишіть середовище навколо вас («Стіни білі. П’ять рожевих стільців, біля стіни дерев’яна книжкова полиця…»).\s
					     
					Опишіть ваші буденні заняття в деталях (наприклад, покрокове приготування страви…).\s
					     
					Скажіть твердження безпеки: «Мене звати… Я в безпеці, я тут і тепер, не в минулому».\s
					     
					Порахуйте до 10, 100, зворотний рахунок, можна співати або продекламувати вірш.\s
					     
					Фізична стабілізація\s
					     
					Пустіть прохолодну або теплу воду собі на руки.\s
					     
					Поплескайте себе по плечах чи стегнах, порухайте великими пальцями стоп, потягніться, покрутіть головою, стисніть і розтисніть кулаки, випряміть пальці.\s
					     
					Втисніть п’яти в підлогу і зверніть увагу, як вони напружились.\s
					     
					Зверніть увагу на своє тіло (вага тіла на стільці, як тисне крісло на тіло…).\s
					     
					Торкніться свого «заземлюючого» предмета (наприклад, стільця), після негативної реакції на щось.\s
					     
					Стабілізаційна техніка в уяві: вправа «Безпечне місце» \s
					     
					Уявіть місце, де вам добре й безпечно, спробуйте відчути на дотик, де ви сидите, що бачите, який там запах, що приємного на смак ви відчуваєте, яка звучить музика.\s
					     
					(за даними із сайту dovidka.info)\s
					""");

			NewsArticle article2 = new NewsArticle(null, "Юридична консультація", """
					Рідні зниклого безвісти військового можуть отримувати його заробітну плату. \s
					     
					Щоб оформити грошове забезпечення зниклого безвісти військовослужбовця, рідним необхідно звернутися до ТЦК та СП. \s
					     
					Бланк заяви можна отримати безпосередньо у військкоматі або ж у регіонального координатора Уповноваженого зі зниклих безвісти.\s
					     
					 При собі необхідно мати: \s
					     
					 ▪️копії сторінок паспорта всіх повнолітніх членів сім’ї з даними про прізвище, ім’я, по батькові й реєстрацію місця проживання (перебування);\s
					     
					▪️довідку про реєстрацію місця проживання (перебування) членів сім’ї (у разі відсутності такої інформації в паспорті);\s
					     
					▪️копію свідоцтва про шлюб (за наявності);\s
					     
					▪️копії свідоцтва про народження дітей (за наявності);\s
					     
					▪️копії довідки про присвоєння індивідуального податкового номера.\s
					""");

			NewsArticle article3 = new NewsArticle(null, "Повернення до цивільного життя", """
					Цивільні та військові перебувають ніби у двох різних реальностях, тому нерідко їм складно знайти спільну мову.\s
					     
					Бійці, які приїжджають додому в короткі відпустки або вертаються після поранень, часто стикаються з дивною комунікацією, стигматизацією травм та некоректними питаннями.\s
					     
					Психологи зазначають, що деструктивна комунікація може призвести до самоізоляції військових: вони уникатимуть розмов з близькими чи друзями, менше прагнутимуть опинитись в соціумі.\s
					     
					Як коректно говорити з військовими дають поради психологи. \s
					     
					Не ставте дурних питань та не "витягуйте" відповіді\s
					     
					Психолог не радить ставити питання про службу ("А як там було? Що робив?"), обов'язки чи побратимів ("Скільки людей вбив?", "А як там наші?" тощо).\s
					     
					На війні є по суті одна мета – вижити. Тому часто психіка і тіло кидає всі зусилля на це. А зв'язок із зовнішнім світом – тьмяніє. До стресових ситуацій додається втома, особисті переживання, пригнічені емоції тощо. Це все в комплексі впливає на те, що говорить військовий та як він це робить", – зазначає він.\s
					     
					Фахівець нагадує, що військові  виконують  накази,  бойові  завдання, ліквідують ворога, захищають всю країну від нападу. Тому рефлексії чи спогади для них поки не на часі. Крім того, деякі теми можуть бути для них важкими.\s
					     
					"Військовослужбовці відвикають від цивільного життя, бо мають на війні іншу реальність. Тому комунікація в побуті дуже залежить від ступеня довіри у стосунках. Людина сама розповість про те, що вважатиме за потрібне, коли прийде час", – каже психолог.\s
					     
					Він зауважує, що військові в побуті можуть лишатися напруженими та тримати ситуацію під контролем. Однак не варто поспішати з рекомендаціями щодо розслаблення або “відпускання” ситуації.\s
					     
					"Кожен військовослужбовець може повернутись до нормального життя в індивідуальні терміни. Однак дуже багато залежить від його психоемоційного стану", – зазначає спеціаліст.\s
					     
					4 правила спілкування вдома\s
					     
					1. Прийняти думку і пояснити дітям (за потреби), що чоловік не такий, як був. Його треба вивчити, його вподобання можуть змінитись, комунікація, режим сну тощо.\s
					‍\s
					2. Якщо є короткочасні спалахи агресії – варто відступити й дати людині простір. "Військовий може реагувати гостріше на певні моменти. Однак не треба поспішати "вести" йому допомогу та "робити добро", – наголошує психолог.\s
					‍\s
					3. Не робити різких рухів, не будити та попереджувати вголос про "вторгнення" в їхній простір (наприклад, коли заходите в кімнату).\s
					‍\s
					4. Залучати до звичайних процесів виключно за бажанням.\s
					     
					"Якщо людина приїхала додому у відпустку, то варто дати право вирішувати, чи хоче вона робити щось в побуті, чи прагне навпаки – сну, тиші та розуміння", – каже психолог.\s
					     
					\s
					     
					Він радить говорити про побутові речі та радіти тому, що ця людина зараз поруч.\s
					     
					Проявляйте емпатію, а не співчуття\s
					     
					Психолог наголошує: не можна жаліти військового, а також вживати фрази на кшталт "Я тебе розумію", "Все буде добре", "Ти – мій герой".\s
					     
					У розмові краще використовувати: "Я тобою пишаюсь", "Я зараз можу це робити, тому що ти мене захищаєш", "Ти – мій захисник".\s
					     
					"На вулиці можна підійти до військового: без різких рухів, привітатися та висловити подяку за те, що він робить. Але варто узагальнити, адже насправді ви не знаєте про цю людину рівно нічого – ані про досвід, ані про обов'язки тощо", – каже психолог.\s
					     
					Поради щодо спілкування з військовими:\s
					1. Дайте людині висловитись.\s
					2. Не робіть нічого непередбачуваного.\s
					3. Жодної критики, порад та ярликів.\s
					     
					Також психолог зазначає, що не треба допомагати людям без їхнього дозволу чи прохання.\s
					     
					"Взагалі треба викинути з голови упередження, що військовий – це якась інша людина, яка потребує іншого ставлення або допомоги. Навіть бійці після поранення – це люди. І кожен має право звернутись за допомогою або робити щось самотужки", – зауважує фахівець.\s
					     
					Він додає, що це стосується й бійців після поранення, з ампутованими кінцівками, опіками тощо. При контакті з такими військовими перш за все варто підтримувати зоровий контакт, але не витріщатись, бо уникнення погляду можуть розцінити як страх чи жалість.\s
					     
					Що варто враховувати роботодавцям\s
					     
					Демобілізовані військові – такі ж рівноправні учасники ринку праці, як і решта кандидатів. Питання поділу цих категорій не повинно бути в принципі. Різниця може бути лише в тому, що за час служби кандидат міг частково втратити навички роботи, до чого роботодавцю необхідно підходити з розумінням і давати час на адаптацію.\s
					     
					Варто пам’ятати, що військові мають дуже цінні персональні якості, наприклад, командна робота, орієнтація на результат та дисципліна.\s
					     
					Під час співбесіди краще уникати питань, які пов'язані з військовою службою, адже вони можуть бути недоречними.\s
					     
					Також не можна використовувати питання, які можуть навіть побічно натякати на припущення про те, що війна могла вплинути на фізичний чи психологічний стан кандидата, адже це один з елементів дискримінації\s
					     
					Фахівець наголошує на потребі створення рівних умов для всіх працівників компанії. Оскільки надмірна увага може розцінюватися як опіка та створювати незручності для колишнього військового й інших співробітників.\s
					     
					(За даними із сайту life.pravda.com.ua  )\s
					""");


			List<NewsArticle> news = new ArrayList<>();
			news.add(article1);
			news.add(article2);
			news.add(article3);

			repository.saveAll(news);
		};
	}

}
